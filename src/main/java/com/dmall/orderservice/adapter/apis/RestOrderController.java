package com.dmall.orderservice.adapter.apis;


import com.dmall.orderservice.domain.model.Order;
import com.dmall.orderservice.domain.model.OrderDetail;
import com.dmall.orderservice.service.OrderReadService;
import com.dmall.orderservice.service.OrderWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/orders")
public class RestOrderController implements OrderController {
    private final OrderWriteService orderWriteService;
    private final OrderReadService orderReadService;

    @Autowired
    public RestOrderController(OrderWriteService orderWriteService, OrderReadService orderReadService) {
        this.orderWriteService = orderWriteService;
        this.orderReadService = orderReadService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDetail createOrder(@Valid @RequestBody CreateOrderRequest request) {
        Order order = orderWriteService.createOrder(request.productId, request.quantity, request.totalPrice, request.address, request.phoneNumber);
        return orderReadService.getOrder(order.getId());
    }

    @GetMapping("/{orderId}")
    public OrderDetail getOrder(@NotNull @PathVariable String orderId) {
//        return new Order("1", 1, 10, new BigDecimal(100), "address001", "110", true, "qixi");
        return orderReadService.getOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable String orderId) {
        orderWriteService.paidOrder(orderId);
    }
}
