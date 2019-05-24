package com.dmall.orderservice.domain.event;

import com.dmall.orderservice.domain.model.Order;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class OrderCreatedEvent {
    private final String id;
    private final long productId;
    private final int quantity;
    private final BigDecimal totalPrice;
    private final String address;
    private final String phoneNumber;
    private boolean paid;
    private String lockId;
    private String eventType = "OrderCreated";

    public static OrderCreatedEvent from(Order order) {

        return OrderCreatedEvent.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .address(order.getAddress())
                .phoneNumber(order.getPhoneNumber())
                .paid(order.isPaid())
                .lockId(order.getLockId())
                .build();
    }
}
