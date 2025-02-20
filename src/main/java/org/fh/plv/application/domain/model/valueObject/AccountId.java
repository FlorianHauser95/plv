package org.fh.plv.application.domain.model.valueObject;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public final class AccountId {

    @NonNull
    private final String id;

}