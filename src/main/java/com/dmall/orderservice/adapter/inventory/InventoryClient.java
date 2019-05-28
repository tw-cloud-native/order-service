package com.dmall.orderservice.adapter.inventory;

//TODO change to use feign client
public interface InventoryClient {
    String lock(Lock lock);

    void unlock(String lockId);
}
