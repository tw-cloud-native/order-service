package com.dmall.orderservice.adapter.product;


import com.dmall.orderservice.adapter.product.fallback.ProductFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${dmall.inventory.url}", name = "product", fallback = ProductFeignFallback.class)
public interface ProductFeign {
    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}/name")
    String getProductName(Long id);

    //TODO correct
}