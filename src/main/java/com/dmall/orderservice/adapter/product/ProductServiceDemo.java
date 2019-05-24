package com.dmall.orderservice.adapter.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceDemo implements ProductService {
    private final ProductFeign productFeign;

    @Autowired
    public ProductServiceDemo(ProductFeign productFeign) {
        this.productFeign = productFeign;
    }

    @Override
    public String getProductName(Long productId) {
        return productFeign.getProductName(productId);

    }

    @Override
    public String getProductImage() {
        return new ProductImageGetterCommand().execute();
    }
}
