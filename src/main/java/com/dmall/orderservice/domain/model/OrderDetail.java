package com.dmall.orderservice.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetail {
    private Order order;
    private String productName;
    private String comment;
}
