package com.dmall.orderservice.contract.base;

import com.dmall.orderservice.adapter.apis.OrderController;
import com.dmall.orderservice.service.OrderReadService;
import com.dmall.orderservice.service.OrderWriteService;
import com.dmall.orderservice.domain.model.Order;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderBase {
    @Before
    public void setup() {
        final OrderWriteService orderWriteService = mock(OrderWriteService.class);
        final OrderReadService orderReadService = mock(OrderReadService.class);

        when(orderWriteService.createOrder(anyLong(), anyInt(), any(BigDecimal.class), anyString(), anyString()))
                .thenReturn(
                        new Order("order-id-1", 1, 10, new BigDecimal("1"), "address", "phoneNumber", false, "1")
                );
//        when(orderReadService.get(anyString())).thenReturn(
//                new Order("1", 1, 10, new BigDecimal(100), "address001", "110", true, "1")
//        );
        RestAssuredMockMvc.standaloneSetup(new OrderController(orderWriteService, orderReadService));
    }
}
