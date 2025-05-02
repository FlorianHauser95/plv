package org.fh.waiterApp.application.domain.model.valueObject;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {
    @NotBlank
    private final String item;
}