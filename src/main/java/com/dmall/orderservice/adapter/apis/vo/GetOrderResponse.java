package com.dmall.orderservice.adapter.apis.vo;

import com.dmall.orderservice.domain.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetOrderResponse {
    private Order order;
    private String productName;
    private String comment;
}
