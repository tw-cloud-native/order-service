package com.dmall.orderservice.service;

import com.dmall.orderservice.adapter.comment.CommentService;
import com.dmall.orderservice.adapter.db.OrderRepository;
import com.dmall.orderservice.adapter.product.ProductFeign;
import com.dmall.orderservice.domain.model.Order;
import com.dmall.orderservice.domain.model.OrderDetail;
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

    public OrderDetail getOrder(String orderId) {
        Order order = orderRepository.getOrder(orderId);

        String productName = productFeign.getProductName(order.getProductId());
        String commentString = commentService.GetCommentString();

        OrderDetail vo = new OrderDetail();
        vo.setOrder(order);
        vo.setProductName(productName);
        vo.setComment(commentString);
        return vo;
    }
}
