package org.fh.plv.application.port.in;

import org.fh.plv.application.domain.model.aggregate.Account;

public interface CreateAccountUseCase {

    Account createAccount(String accountName);

}
