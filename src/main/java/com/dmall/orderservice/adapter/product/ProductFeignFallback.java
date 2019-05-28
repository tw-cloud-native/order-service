package com.dmall.orderservice.adapter.product;

import org.springframework.stereotype.Component;

@Component
public class ProductFeignFallback implements ProductFeign {
    @Override
    public String getProductName(Long productId) {
        return "Powered by fallback";
    }
}
