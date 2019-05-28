package com.dmall.orderservice.adapter.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "http://localhost:8081", name = "product-service", fallback = ProductFeignFallback.class)
public interface ProductFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}/name")
    String getProductName(@PathVariable("id") Long id);
}
