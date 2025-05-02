package org.fh.plv.application.domain.model.aggregate;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.domain.model.valueObject.Money;

@Getter
@Builder
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
}
