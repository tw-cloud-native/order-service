package com.dmall.orderservice.adapter.apis;

import com.dmall.orderservice.domain.model.OrderDetail;

public interface OrderController {
    OrderDetail createOrder(CreateOrderRequest request);

    OrderDetail getOrder(String orderId);

    void updateOrder(String orderId);
}
