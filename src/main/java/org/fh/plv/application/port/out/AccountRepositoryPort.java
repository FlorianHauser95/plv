package org.fh.plv.application.port.out;

import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.domain.model.valueObject.AccountId;

import java.util.List;

public interface AccountRepositoryPort {
    Account findById(AccountId id);

    List<Account> findAll();

    Account save(Account vehicle);

    void delete(AccountId id);
}
