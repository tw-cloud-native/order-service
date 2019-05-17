package com.dmall.orderservice.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class Order {
    private final String id;
    private final long productId;
    private final int quantity;
    private final BigDecimal totalPrice;
    private final String address;
    private final String phoneNumber;
    private boolean paid;
    private String lockId;

    public Order(long productId, int quantity, BigDecimal totalPrice, String address, String phoneNumber, String lockId) {
        id = UUID.randomUUID().toString();
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.lockId = lockId;
    }

    public void paid() {
        paid=true;
    }
}
