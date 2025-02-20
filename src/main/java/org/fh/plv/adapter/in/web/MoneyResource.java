package org.fh.successeder.in.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.fh.plv.adapter.in.web.SendMoneyCommandDto;
import org.fh.plv.adapter.in.web.SendMoneyCommandMapper;
import org.fh.plv.application.port.in.SendMoneyUseCase;

@Path("money")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MoneyResource {

    @Inject
    SendMoneyUseCase sendMoneyUseCase;

    @Inject
    SendMoneyCommandMapper sendMoneyCommandMapper;

    @POST
    @Path("send")
    public SendMoneyDto sendMoney(SendMoneyCommandDto sendMoneyCommandDto) {
        return new SendMoneyDto(
                sendMoneyUseCase.sendMoney(
                        sendMoneyCommandMapper.toDomain(sendMoneyCommandDto)));
    }

    public record SendMoneyDto(Boolean succeed) {
    }
}
