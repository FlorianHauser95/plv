package org.fh.plv.application.port.in;

import org.fh.plv.application.domain.model.query.GetAccountBalanceQuery;
import org.fh.plv.application.domain.model.valueObject.Money;

public interface GetAccountBalanceUseCase {
    Money getAccountBalance(GetAccountBalanceQuery query);
}
