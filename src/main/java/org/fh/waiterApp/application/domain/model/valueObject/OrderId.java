package org.fh.waiterApp.application.domain.model.valueObject;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class OrderId {
    @NotBlank
    private final String id;

    public static OrderId generate(){
        return new OrderId(UUID.randomUUID().toString());
    }
}
