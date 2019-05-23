package com.dmall.orderservice.service;

import com.dmall.orderservice.domain.model.order.Order;
import com.dmall.orderservice.domain.model.order.OrderRepository;
import com.dmall.orderservice.adapter.feign.ProductFeign;
import com.dmall.orderservice.adapter.apis.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderReadService {
    private final OrderRepository orderRepository;
    private final ProductFeign productFeign;
    private final CommentService commentService;

    @Autowired
    public OrderReadService(OrderRepository orderRepository, ProductFeign productFeign, CommentService commentService) {
        this.orderRepository = orderRepository;
        this.productFeign = productFeign;
        this.commentService = commentService;
    }

    public OrderVO getOrder(String orderId) {
        Order order = orderRepository.getOrder(orderId);
        String productName = productFeign.getProductName(order.getProductId());
        String comment = commentService.execute();

        OrderVO vo = new OrderVO();
        vo.setOrder(order);
        vo.setProductName(productName);
        vo.setComment(comment);
        return vo;
    }
}
