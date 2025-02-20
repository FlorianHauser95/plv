package org.fh.plv.application.port.in;

import org.fh.plv.application.domain.model.command.SendMoneyCommand;

public interface SendMoneyUseCase {
    boolean sendMoney(SendMoneyCommand sendMoneyCommand);
}
