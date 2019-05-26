package com.dmall.orderservice.adapter.events;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
public class InventoryEvent {
    private String orderId;

    private Long lockId;

    private Long productId;

    private Integer quantity;

    private String eventType;
}
