package com.dmall.orderservice.model.vo;

import com.dmall.orderservice.domain.model.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderVO {
    private Order order;
    private String productName;
    private String comment;
}
