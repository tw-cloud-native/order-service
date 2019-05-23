package com.dmall.orderservice.adapter.db;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderPersistence extends CrudRepository<OrderEntity, String> {
}
