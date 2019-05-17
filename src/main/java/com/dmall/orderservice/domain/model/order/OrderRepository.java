package com.dmall.orderservice.domain.model.order;

public interface OrderRepository {
    Order save(Order order);

    Order getOrder(String orderId);
}

