package com.dmall.orderservice.adapter.events;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EventStreams {

    String OUTPUT_ORDER = "outputOrder";

    //TODO: binding
    MessageChannel outputOrder();

}
