package com.dmall.orderservice.adapter.inventory;

public interface InventoryClient {
    String lock(Lock lock);

    void unlock(String lockId);
}
