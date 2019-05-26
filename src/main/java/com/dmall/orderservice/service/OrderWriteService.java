package com.dmall.orderservice.service;

import com.dmall.orderservice.adapter.db.OrderRepository;
import com.dmall.orderservice.adapter.events.EventStreams;
import com.dmall.orderservice.adapter.inventory.InventoryClient;
import com.dmall.orderservice.domain.event.OrderEvent;
import com.dmall.orderservice.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderWriteService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final EventStreams eventStreams;

    @Autowired
    public OrderWriteService(EventStreams eventStreams, OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
        this.eventStreams = eventStreams;
    }

    public Order createOrder(long productId, int quantity, BigDecimal totalPrice, String address, String phoneNumber) {
//        String lockId = inventoryClient.lock(new Lock(quantity, productId));

        final Order order = new Order(productId, quantity, totalPrice, address, phoneNumber, null);
        orderRepository.save(order);

        eventStreams.outputOrder().send(MessageBuilder.withPayload(OrderEvent.createdEvent(order)).build());
        return order;
    }

    public void payOrder(String orderId) {
        final Order order = orderRepository.getOrder(orderId);
        order.pay();
//        inventoryClient.unlock(order.getLockId());
        orderRepository.save(order);

        eventStreams.outputOrder().send(MessageBuilder.withPayload(OrderEvent.paidEvent(order)).build());
    }

    public void lockInventory(String orderId, Long lockId) {
        final Order order = orderRepository.getOrder(orderId);
        order.lockInventory(lockId.toString());
        orderRepository.save(order);
    }
}
