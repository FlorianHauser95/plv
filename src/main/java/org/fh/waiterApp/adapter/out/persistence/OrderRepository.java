package org.fh.waiterApp.adapter.out.persistence;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements PanacheMongoRepositoryBase<OrderEntity, String> {

}