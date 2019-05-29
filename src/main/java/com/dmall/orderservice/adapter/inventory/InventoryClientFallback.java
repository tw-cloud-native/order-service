package com.dmall.orderservice.adapter.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class InventoryClientFallback implements InventoryClient {
    @Override
    public String lock(Lock lock) {
        return "Unavailable now, check later";
    }

    @Override
    public void unlock(String lockId) {
        log.info("Unavailable now, check later");
    }
}
