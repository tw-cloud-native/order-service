package com.dmall.orderservice.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
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
