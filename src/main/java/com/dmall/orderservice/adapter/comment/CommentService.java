package com.dmall.orderservice.adapter.comment;

import org.springframework.stereotype.Component;

@Component
public class CommentService {
    public String GetComment() {
        return new CommentGetterCommand().execute();
    }
}
