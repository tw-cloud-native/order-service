package com.dmall.orderservice.contract.base;

import com.dmall.orderservice.adapter.comment.GetCommentStringCommand;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductNameCommandTest {
    @Test
    public void shouldGetFallbackResponse() {
        String s = new GetCommentStringCommand().execute();
        assertEquals("Powered by fallback", s);
    }
}
