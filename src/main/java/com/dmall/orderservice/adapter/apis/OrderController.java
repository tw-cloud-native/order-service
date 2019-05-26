package com.dmall.orderservice.adapter.apis;

import com.dmall.orderservice.domain.dto.Order;
import com.dmall.orderservice.domain.dto.OrderContext;

public interface OrderController {
    OrderContext create(Order order);

    OrderContext get(String orderId);

    void updateOrder(String orderId);
}
