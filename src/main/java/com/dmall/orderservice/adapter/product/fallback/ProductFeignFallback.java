package com.dmall.orderservice.adapter.product.fallback;

import com.dmall.orderservice.adapter.product.ProductFeign;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignFallback implements ProductFeign {
    @Override
    public String getProductName(Long productId) {
        return "Powered by fallback";
    }
}