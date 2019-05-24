package com.dmall.orderservice.service;

import com.dmall.orderservice.adapter.db.OrderRepository;
import com.dmall.orderservice.adapter.inventory.InventoryClient;
import com.dmall.orderservice.adapter.inventory.Lock;
import com.dmall.orderservice.adapter.mq.EventStreams;
import com.dmall.orderservice.domain.event.OrderCreatedEvent;
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
        String lockId = inventoryClient.lock(new Lock(quantity, productId));

        final Order order = new Order(productId, quantity, totalPrice, address, phoneNumber, lockId);
        orderRepository.save(order);
        eventStreams.outputOrder().send(MessageBuilder.withPayload(OrderCreatedEvent.from(order)).build());
        return order;
    }

    public void paidOrder(String orderId) {
        final Order order = orderRepository.getOrder(orderId);
        order.paid();
        inventoryClient.unlock(order.getLockId());
        orderRepository.save(order);
    }
}
