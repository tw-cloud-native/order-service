package com.dmall.orderservice.contract.base;

import com.dmall.orderservice.adapter.comment.CommentGetterCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNameCommandTest {
    @Test
    public void shouldGetFallbackResponse() {
        String s = new CommentGetterCommand().execute();
        assertEquals("Powered by fallback", s);
    }
}
