package org.fh.plv.application.domain.model.aggregate;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.domain.model.valueObject.Money;

@Getter
@Builder
@EqualsAndHashCode
public class Account {

    private final AccountId accountId;
    private final String accountName;
    private final Money balance;

    public Account(@NonNull AccountId accountId,
                   @NonNull String accountName,
                   @NonNull Money balance) {
        if (accountName.trim().isEmpty()) {
            throw new IllegalArgumentException("accountName is empty");
        }
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
    }

    public boolean mayWithdraw(Money money) {
        return balance.subtract(money).isPositive();
    }

    public Account withdrawal(Money money) {
        return new Account(getAccountId(), getAccountName(), getBalance().subtract(money));
    }

    public Account deposit(Money money) {
        return new Account(getAccountId(), getAccountName(), getBalance().add(money));
    }
}
