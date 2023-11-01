package racingcar.domain.core.car;

import racingcar.support.SystemProperty;

public enum MoveSignal {
    FORWARD(1L),
    STOP(0L);

    private static final Long STOP_AND_FORWARD_SEPARATOR =
        (long) SystemProperty.STOP_AND_FORWARD_SEPARATOR;

    private final Long distance;

    MoveSignal(Long distance) {
        this.distance = distance;
    }

    public static MoveSignal of(Long source) {
        if (source < STOP_AND_FORWARD_SEPARATOR) {
            return STOP;
        }
        return FORWARD;
    }

    public Long move(Long position) {
        return distance + position;
    }
}
