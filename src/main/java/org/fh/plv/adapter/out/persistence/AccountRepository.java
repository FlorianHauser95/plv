package org.fh.plv.adapter.out.persistence;

import io.quarkus.mongodb.panache.PanacheMongoRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheMongoRepositoryBase<AccountEntity, String> {

}