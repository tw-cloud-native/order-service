package com.dmall.orderservice.adapter.product;

import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Override
    public String getProductName(Long productId) {
        return "Production:" + productId;

    }

    @Override
    public String getProductImage() {
        return "ProductionImage";
    }
}
