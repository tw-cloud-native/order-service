package com.dmall.orderservice.contract.base;

import com.dmall.orderservice.application.CommentService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNameCommandTest {
    @Test
    public void shouldGetFallbackResponse() {
        String s = new CommentService().execute();
        assertEquals("Powered by fallback", s);
    }
}
