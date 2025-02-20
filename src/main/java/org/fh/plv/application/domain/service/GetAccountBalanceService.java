package org.fh.plv.application.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.domain.model.query.GetAccountBalanceQuery;
import org.fh.plv.application.domain.model.valueObject.Money;
import org.fh.plv.application.port.in.GetAccountBalanceUseCase;
import org.fh.plv.application.port.out.AccountRepositoryPort;

@ApplicationScoped
public class GetAccountBalanceService implements GetAccountBalanceUseCase {

    @Inject
    AccountRepositoryPort accountRepositoryPort;

    @Override
    public Money getAccountBalance(GetAccountBalanceQuery query) {
        Account account = accountRepositoryPort.findById(query.getAccountId());
        return account.getBalance();
    }
}
