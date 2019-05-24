package com.dmall.orderservice.adapter.apis;

import com.dmall.orderservice.domain.dto.CreateOrderRequest;
import com.dmall.orderservice.domain.dto.OrderDetail;

public interface OrderController {
    OrderDetail createOrder(CreateOrderRequest request);

    OrderDetail getOrder(String orderId);

    void updateOrder(String orderId);
}
