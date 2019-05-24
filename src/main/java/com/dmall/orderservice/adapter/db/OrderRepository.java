package com.dmall.orderservice.adapter.db;

import com.dmall.orderservice.domain.model.Order;

public interface OrderRepository {
    Order save(Order order);

    Order getOrder(String orderId);
}

