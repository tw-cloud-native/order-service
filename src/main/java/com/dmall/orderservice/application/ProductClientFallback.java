package com.dmall.orderservice.application;

import org.springframework.stereotype.Component;

@Component
public class ProductClientFallback implements ProductClient {
    @Override
    public String getProductName(Long productId) {
        return "Powered by fallback";
    }
}