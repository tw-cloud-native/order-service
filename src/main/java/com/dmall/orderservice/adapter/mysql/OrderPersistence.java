package com.dmall.orderservice.adapter.mysql;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface OrderPersistence extends CrudRepository<OrderEntity, String> {
}
