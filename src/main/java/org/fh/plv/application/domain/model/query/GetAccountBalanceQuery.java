package org.fh.plv.application.domain.model.query;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import org.fh.plv.application.domain.model.valueObject.AccountId;

@Getter
@EqualsAndHashCode
public class GetAccountBalanceQuery {
    private final AccountId accountId;

    public GetAccountBalanceQuery(@NonNull AccountId accountId) {
        this.accountId = accountId;
    }
}
