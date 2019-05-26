package com.dmall.orderservice.domain.event;

import com.dmall.orderservice.domain.model.Order;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class OrderEvent {
    public static final String ORDER_CREATED = "OrderCreated";
    public static final String ORDER_PAID = "OrderPaid";

    private final String id;
    private final long productId;
    private final int quantity;
    private final BigDecimal totalPrice;
    private final String address;
    private final String phoneNumber;
    private boolean paid;
    private String lockId;
    private String eventType;

    public static OrderEvent createdEvent(Order order) {
        OrderEvent orderEvent = build(order, ORDER_CREATED);
        return orderEvent;
    }

    public static OrderEvent paidEvent(Order order) {
        OrderEvent orderEvent = build(order, ORDER_PAID);
        return orderEvent;
    }

    private static OrderEvent build(Order order, String eventType) {
        return OrderEvent.builder()
                .id(order.getId())
                .productId(order.getProductId())
                .quantity(order.getQuantity())
                .totalPrice(order.getTotalPrice())
                .address(order.getAddress())
                .phoneNumber(order.getPhoneNumber())
                .paid(order.isPaid())
                .lockId(order.getLockId())
                .eventType(eventType)
                .build();
    }
}
