package com.dmall.orderservice.domain.dto;

import com.dmall.orderservice.domain.model.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderContxt {
    private Order order;
    private String productName;
    private String productImage;
}
