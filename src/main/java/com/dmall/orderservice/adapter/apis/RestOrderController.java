package com.dmall.orderservice.adapter.apis;


import com.dmall.orderservice.adapter.apis.vo.CreateOrderRequest;
import com.dmall.orderservice.adapter.apis.vo.GetOrderResponse;
import com.dmall.orderservice.domain.model.Order;
import com.dmall.orderservice.domain.service.OrderReadService;
import com.dmall.orderservice.domain.service.OrderWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public Order createOrder(@Valid @RequestBody CreateOrderRequest request) {
        return orderWriteService.createOrder(request.productId, request.quantity, request.totalPrice, request.address, request.phoneNumber);
    }

    @GetMapping("/{orderId}")
    public GetOrderResponse getOrder(@PathVariable String orderId) {
//        return new Order("1", 1, 10, new BigDecimal(100), "address001", "110", true, "qixi");
        return orderReadService.getOrder(orderId);
    }

    @PutMapping("/{orderId}")
    public void updateOrder(@PathVariable String orderId) {
        orderWriteService.paidOrder(orderId);
    }
}
