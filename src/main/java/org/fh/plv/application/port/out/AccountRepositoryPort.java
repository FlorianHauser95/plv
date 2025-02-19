package org.fh.plv.application.port.out;

import org.fh.plv.application.domain.model.aggregate.Account;

import java.util.List;

public interface AccountRepositoryPort {
    Account findById(String id);

    List<Account> findAll();

    Account save(Account vehicle);

    void delete(String id);
}
