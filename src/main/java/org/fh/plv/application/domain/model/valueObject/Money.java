package org.fh.plv.application.domain.model.valueObject;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
@EqualsAndHashCode
public final class Money {
    @NonNull
    private final BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money add(Money other) {
        return new Money(this.amount.add(other.amount));
    }

    public Money subtract(Money other) {
        return new Money(this.amount.subtract(other.amount));
    }

    public boolean isPositive() {
        return amount.compareTo(BigDecimal.ZERO) >= 0;
    }
}