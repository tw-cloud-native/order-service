package com.dmall.orderservice.adapter.inventory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//TODO: remove restTemplate implement
@Component
public class InventoryClientImpl implements InventoryClient {

    @Value("${dmall.inventory.url}")
    private String inventoryServiceUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public String lock(Lock lock) {
        return restTemplate.postForEntity(inventoryServiceUrl + "/inventories/lock", lock, String.class).getBody();
    }

    public void unlock(String lockId) {
        restTemplate.put(inventoryServiceUrl + "/inventories/lock/" + lockId, null);
    }
}
