package com.dmall.orderservice.adapter.apis;

import com.dmall.orderservice.adapter.apis.vo.CreateOrderRequest;
import com.dmall.orderservice.adapter.apis.vo.GetOrderResponse;
import com.dmall.orderservice.domain.model.Order;

public interface OrderController {
    Order createOrder(CreateOrderRequest request);

    GetOrderResponse getOrder(String orderId);

    void updateOrder(String orderId);
}
