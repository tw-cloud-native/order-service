package com.dmall.orderservice.application;

import com.dmall.orderservice.domain.model.order.Order;
import com.dmall.orderservice.domain.model.order.OrderRepository;
import com.dmall.orderservice.model.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Service
public class OrderReadService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final CommentService commentService;

    @Autowired
    public OrderReadService(OrderRepository orderRepository, ProductClient productClient, CommentService commentService) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
        this.commentService = commentService;
    }

    public OrderVO getOrder(String orderId) {
        Order order = orderRepository.getOrder(orderId);
        String productName = productClient.getProductName(order.getProductId());
        String comment = commentService.execute();

        OrderVO vo = new OrderVO();
        vo.setOrder(order);
        vo.setProductName(productName);
        vo.setComment(comment);
        return vo;
    }
}
