package com.dmall.orderservice.adapter.apis;

import com.dmall.orderservice.domain.dto.Order;
import com.dmall.orderservice.domain.dto.OrderContxt;

public interface OrderController {
    OrderContxt create(Order order);

    OrderContxt get(String orderId);

    void updateOrder(String orderId);
}
