package org.fh.plv.application.domain.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.fh.plv.application.domain.model.aggregate.Account;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.domain.model.valueObject.Money;
import org.fh.plv.application.port.in.CreateAccountUseCase;
import org.fh.plv.application.port.out.AccountRepositoryPort;

import java.math.BigDecimal;
import java.util.UUID;

@ApplicationScoped
public class AccountService implements CreateAccountUseCase {
    @Inject
    AccountRepositoryPort accountRepositoryPort;

    private static final BigDecimal INIT_BALANCE = BigDecimal.ZERO;

    @Override
    public Account createAccount(String accountName) {
        AccountId accountId = generateNewAccountId();
        Money balance = generateNewMoney(INIT_BALANCE);
        Account newAccount = Account.builder()
                .accountId(accountId)
                .accountName(accountName)
                .balance(balance)
                .build();
        accountRepositoryPort.save(newAccount);
        return newAccount;
    }

    private AccountId generateNewAccountId() {
        return AccountId.builder()
                .id(UUID.randomUUID().toString())
                .build();
    }

    private Money generateNewMoney(BigDecimal amount) {
        return Money.builder()
                .amount(amount)
                .build();
    }
}
