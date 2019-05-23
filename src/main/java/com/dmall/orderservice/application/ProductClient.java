package com.dmall.orderservice.application;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${dmall.inventory.url}", name = "product", fallback = ProductClientFallback.class)
public interface ProductClient {
    @RequestMapping(method = RequestMethod.POST, value = "/404")
    String getProductName(Long productId);
}