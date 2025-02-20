package org.fh.plv.adapter.in.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fh.plv.application.domain.model.query.GetAccountBalanceQuery;
import org.fh.plv.application.domain.model.valueObject.AccountId;
import org.fh.plv.application.port.in.CreateAccountUseCase;
import org.fh.plv.application.port.in.GetAccountBalanceUseCase;

import java.math.BigDecimal;

@Path("account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    CreateAccountUseCase createAccountUseCase;

    @Inject
    GetAccountBalanceUseCase getAccountBalanceUseCase;

    @Inject
    AccountResourceMapper accountResourceMapper;

    @POST
    @Path("create")
    public Response createAccount(CreateAccountDto createAccountDto) {
        return Response.status(Response.Status.CREATED)
                .entity(accountResourceMapper.toDto(
                        createAccountUseCase.createAccount(createAccountDto.getAccountName()))
                ).build();
    }

    @GET
    @Path("balance/{id}")
    public AccountBalanceResponse getBalance(@PathParam("id") String id) {
        return new AccountBalanceResponse(
                getAccountBalanceUseCase.getAccountBalance(new GetAccountBalanceQuery(new AccountId(id)))
                        .getAmount());
    }

    public record AccountBalanceResponse(BigDecimal balance) {
    }
}
