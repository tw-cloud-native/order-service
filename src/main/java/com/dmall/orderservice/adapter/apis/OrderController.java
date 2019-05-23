package com.dmall.orderservice.adapter.apis;


import com.dmall.orderservice.application.OrderWriteService;
import com.dmall.orderservice.application.OrderReadService;
import com.dmall.orderservice.domain.model.order.Order;
import com.dmall.orderservice.model.vo.OrderVO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderWriteService orderWriteService;
    private final OrderReadService orderReadService;

    @Autowired
    public OrderController(OrderWriteService orderWriteService, OrderReadService orderReadService) {
        this.orderWriteService = orderWriteService;
        this.orderReadService = orderReadService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderWriteService.createOrder(request.productId, request.quantity, request.totalPrice, request.address, request.phoneNumber);
    }

    @GetMapping("/{orderId}")
    public OrderVO getOrder(@PathVariable String orderId) {
//        return new Order("1", 1, 10, new BigDecimal(100), "address001", "110", true, "qixi");
        return orderReadService.getOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable String orderId, UpdateOrderRequest updateOrderRequest) {
        orderWriteService.paidOrder(orderId);
    }

    @Setter
    private static class CreateOrderRequest {
        @NotNull
        private Long productId;
        @NotNull
        private Integer quantity;
        @NotNull
        private BigDecimal totalPrice;
        @NotNull
        private String address;
        @NotNull
        private String phoneNumber;
    }

    @Setter
    private static class UpdateOrderRequest {
        Boolean paid;
    }
}
