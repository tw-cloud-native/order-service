package com.dmall.orderservice.adapter.db;

import com.dmall.orderservice.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private final OrderPersistence orderPersistence;

    @Autowired
    public OrderRepositoryImpl(OrderPersistence orderPersistence) {
        this.orderPersistence = orderPersistence;
    }

    public Order save(Order order) {
        final OrderEntity orderEntity = new OrderEntity(order);
        orderPersistence.save(orderEntity);
        return order;
    }

    @Override
    public Order getOrder(String orderId) {
        return orderPersistence
                .findById(orderId)
                .map(entity -> new Order(entity.getId(), entity.getProductId(),
                        entity.getQuantity(), entity.getTotalPrice(), entity.getAddress(),
                        entity.getPhoneNumber(), entity.isPaid(), entity.getLockId()))
                .orElse(null);

    }
}
