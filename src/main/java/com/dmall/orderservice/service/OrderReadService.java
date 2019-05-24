package com.dmall.orderservice.service;

import com.dmall.orderservice.adapter.db.OrderRepository;
import com.dmall.orderservice.adapter.product.ProductService;
import com.dmall.orderservice.domain.dto.OrderContxt;
import com.dmall.orderservice.domain.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderReadService {
    private final OrderRepository orderRepository;
    private final ProductService productService;

    @Autowired
    public OrderReadService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public OrderContxt getOrder(String orderId) {
        Order order = orderRepository.getOrder(orderId);

        String productName = productService.getProductName(order.getProductId());
        String productImage = productService.getProductImage();

        OrderContxt context = new OrderContxt();
        context.setOrder(order);
        context.setProductName(productName);
        context.setProductImage(productImage);
        return context;
    }
}
