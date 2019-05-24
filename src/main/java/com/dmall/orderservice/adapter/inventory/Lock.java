package com.dmall.orderservice.adapter.inventory;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Lock {
    int quantity;
    long productId;
}