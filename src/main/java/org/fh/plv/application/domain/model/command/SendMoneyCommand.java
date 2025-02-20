package org.fh.plv.application.domain.model.command;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.domain.model.valueObject.Money;

@Getter
@EqualsAndHashCode
public class SendMoneyCommand {
    private final AccountId sourceAccountId;
    private final AccountId targetAccountId;
    private final Money money;

    public SendMoneyCommand(@NonNull AccountId sourceAccountId,
                            @NonNull AccountId targetAccountId,
                            @NonNull Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;

        if(!money.isPositive()) {
            throw new IllegalArgumentException("money lower than or equal zero");
        }
    }
}
