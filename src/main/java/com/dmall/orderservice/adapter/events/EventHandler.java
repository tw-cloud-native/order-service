package com.dmall.orderservice.adapter.events;


import com.dmall.orderservice.service.OrderWriteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventHandler {

  private OrderWriteService orderWriteService;

  @Autowired
  public EventHandler(OrderWriteService orderWriteService) {
    this.orderWriteService = orderWriteService;
  }

  @StreamListener(EventStreams.INPUT_INVENTORY)
  public void receive(InventoryEvent event) {
    log.info("=======received：" + event.toString());

    if ("InventoryLocked".equals(event.getEventType())) {
      orderWriteService.lockInventory(event.getOrderId(), event.getLockId());
    }
  }
}
