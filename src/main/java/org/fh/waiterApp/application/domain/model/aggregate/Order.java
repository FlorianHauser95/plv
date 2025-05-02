package org.fh.waiterApp.application.domain.model.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.fh.waiterApp.application.domain.model.valueObject.*;

@Getter
@AllArgsConstructor
public class Order {
    @NonNull
    private final OrderId id;
    @NonNull
    private final TableNumber tableNumber;
    @NonNull
    private final Item item;
    @NonNull
    private final Quantity quantity;
    @NonNull
    private Status status;

    public void startPreparation() {
        changeStatusTo(Status.PREPARING);
    }

    public void markReadyForDelivery() {
        changeStatusTo(Status.READY_FOR_DELIVERY);
    }

    public void deliver() {
        changeStatusTo(Status.DELIVERED);
    }

    public void cancel() {
        changeStatusTo(Status.CANCELLED);
    }

    private void changeStatusTo(Status newStatus) {
        if (!this.status.canTransitionTo(newStatus)) {
            throw new IllegalStateException(
                    String.format("Invalid status transition: %s → %s", this.status, newStatus)
            );
        }
        this.status = newStatus;
        // TODO: publish Domain Event, e.g. OrderStatusChanged(this.id, newStatus);
    }
}
