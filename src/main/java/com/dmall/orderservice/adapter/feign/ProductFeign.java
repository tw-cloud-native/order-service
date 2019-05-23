package com.dmall.orderservice.adapter.feign;


import com.dmall.orderservice.adapter.feign.fallback.ProductFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${dmall.inventory.url}", name = "product", fallback = ProductFeignFallback.class)
public interface ProductFeign {
    @RequestMapping(method = RequestMethod.POST, value = "/404")
    String getProductName(Long productId);
}