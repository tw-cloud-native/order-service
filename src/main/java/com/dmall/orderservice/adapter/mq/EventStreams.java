package com.dmall.orderservice.adapter.mq;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventStreams {

    String OUTPUT_ORDER = "outputOrder";

    @Output(OUTPUT_ORDER)
    MessageChannel outputOrder();
}
