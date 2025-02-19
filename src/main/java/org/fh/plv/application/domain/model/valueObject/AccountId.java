package org.fh.plv.application.domain.model.valueObject;

import lombok.*;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public final class AccountId {

    @NonNull
    private final String id;

}