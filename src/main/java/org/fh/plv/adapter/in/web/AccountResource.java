package org.fh.plv.adapter.in.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.fh.plv.application.port.in.CreateAccountUseCase;

@Path("account")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AccountResource {

    @Inject
    CreateAccountUseCase createAccountUseCase;

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
}
