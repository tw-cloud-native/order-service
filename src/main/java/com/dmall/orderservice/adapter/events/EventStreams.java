package com.dmall.orderservice.adapter.events;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface EventStreams {

    String OUTPUT_ORDER = "outputOrder";
    String INPUT_INVENTORY = "inputInventory";

    @Output(OUTPUT_ORDER)
    MessageChannel outputOrder();

    @Input(INPUT_INVENTORY)
    SubscribableChannel inputInventory();

}
