package com.dmall.orderservice.service;

import com.dmall.orderservice.adapter.db.OrderRepository;
import com.dmall.orderservice.adapter.inventory.InventoryClient;
import com.dmall.orderservice.adapter.inventory.Lock;
import com.dmall.orderservice.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderWriteService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    @Autowired
    public OrderWriteService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public Order createOrder(long productId, int quantity, BigDecimal totalPrice, String address, String phoneNumber) {
        String lockId = inventoryClient.lock(new Lock(quantity, productId));

        final Order order = new Order(productId, quantity, totalPrice, address, phoneNumber, lockId);
        orderRepository.save(order);

        return order;
    }

    public void payOrder(String orderId) {
        final Order order = orderRepository.getOrder(orderId);
        order.pay();
        inventoryClient.unlock(order.getLockId());
        orderRepository.save(order);

    }

    public void lockInventory(String orderId, Long lockId) {
        final Order order = orderRepository.getOrder(orderId);
        order.lockInventory(lockId.toString());
        orderRepository.save(order);
    }
}
