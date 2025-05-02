package org.fh.waiterApp.application.domain.model.valueObject;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TableNumber {
    @NonNull
    private final String tableNumber;
}