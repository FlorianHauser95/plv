package org.fh.plv.adapter.out.persistence;

import io.quarkus.mongodb.panache.common.MongoEntity;
import org.bson.codecs.pojo.annotations.BsonId;

import java.math.BigDecimal;

@MongoEntity(collection = "accounts")
public class AccountEntity {
    @BsonId
    public String id;
    public String accountName;
    public BigDecimal balance;
}