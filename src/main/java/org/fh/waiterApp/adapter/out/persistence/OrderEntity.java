package org.fh.waiterApp.adapter.out.persistence;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;

@Data
@MongoEntity(collection = "orders")
public class OrderEntity {
    @BsonId
    private String id;
    private String tableNumber;
    private String item;
    private Integer quantity;
    private String status;
}