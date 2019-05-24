package com.dmall.orderservice.domain.dto;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class CreateOrderRequest {
    @NotNull
    public Long productId;
    @NotNull
    public Integer quantity;
    @NotNull
    public BigDecimal totalPrice;
    @NotNull
    public String address;
    @NotNull
    public String phoneNumber;
}
