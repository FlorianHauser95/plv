package org.fh.waiterApp.application.domain.model.valueObject;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
public class Status {

    private static final Set<String> REGISTERED_KEYS = new HashSet<>();

    public static final Status NEW = register("new");
    public static final Status PREPARING = register("preparing");
    public static final Status READY_FOR_DELIVERY = register("ready_for_delivery");
    public static final Status DELIVERED = register("delivered");
    public static final Status CANCELLED = register("cancelled");

    private static Status register(String key) {
        REGISTERED_KEYS.add(key);
        return new Status(key);
    }

    private static final Map<Status, Set<Status>> ALLOWED_TRANSITIONS;

    static {
        ALLOWED_TRANSITIONS = Map.of(
                NEW, Set.of(PREPARING, CANCELLED),
                PREPARING, Set.of(READY_FOR_DELIVERY, CANCELLED),
                READY_FOR_DELIVERY, Set.of(DELIVERED, CANCELLED),
                DELIVERED, Collections.emptySet(),
                CANCELLED, Collections.emptySet());
    }

    private final String status;

    public Status(String status) {
        if (StringUtils.isBlank(status)) {
            throw new IllegalArgumentException("status is blank");
        }
        if (!REGISTERED_KEYS.contains(status)) {
            throw new IllegalArgumentException("status is illegal");
        }
        this.status = status;
    }

    public boolean canTransitionTo(Status target) {
        Set<Status> allowed = ALLOWED_TRANSITIONS.get(this);
        return allowed != null && allowed.contains(target);
    }
}
