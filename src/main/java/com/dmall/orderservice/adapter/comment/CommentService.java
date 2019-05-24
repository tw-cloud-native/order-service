package com.dmall.orderservice.adapter.comment;

import org.springframework.stereotype.Component;

@Component
public class CommentService {
    public String GetCommentString() {
        return new GetCommentStringCommand().execute();
    }
}
