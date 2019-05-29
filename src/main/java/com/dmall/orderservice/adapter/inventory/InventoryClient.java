package com.dmall.orderservice.adapter.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "inventory-service", fallback = InventoryClientFallback.class)
public interface InventoryClient {
    @RequestMapping(method = RequestMethod.POST, value = "/inventories/lock")
    String lock(Lock lock);

    @RequestMapping(method = RequestMethod.PUT, value = "/inventories/lock/{lockId}")
    void unlock(@PathVariable("lockId") String lockId);
}
