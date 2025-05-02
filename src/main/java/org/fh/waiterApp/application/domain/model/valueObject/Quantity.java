package org.fh.waiterApp.application.domain.model.valueObject;

import lombok.Getter;

@Getter
public class Quantity {
    private final int quantity;

    public Quantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity should be greater than zero");
        this.quantity = quantity;
    }
}
