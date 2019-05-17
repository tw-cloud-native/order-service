package com.dmall.orderservice.adapter.apis;


import com.dmall.orderservice.application.OrderApplicationService;
import com.dmall.orderservice.domain.model.order.Order;
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
    private final OrderApplicationService orderApplicationService;

    @Autowired
    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Order createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderApplicationService.createOrder(request.productId, request.quantity, request.totalPrice, request.address, request.phoneNumber);
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable String orderId) {
//        return new Order("1", 1, 10, new BigDecimal(100), "address001", "110", true, "qixi");
        return orderApplicationService.getOrder(orderId);
    }
  
    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable String orderId,UpdateOrderRequest updateOrderRequest){
        orderApplicationService.paidOrder(orderId);
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
