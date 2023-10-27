package racingcar.domain;

import java.util.Arrays;
import java.util.Objects;

public enum CarState {
    MOVING(true),
    STOPPED(false);

    private static final String NOT_FOUNT_ERROR = "값을 찾을 수 없습니다.";
    private final boolean value;

    CarState(boolean value) {
        this.value = value;
    }

    public static CarState from(boolean value) {
        return Arrays.stream(CarState.values())
                .filter(it -> Objects.equals(it.value, value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUNT_ERROR));
    }
}
