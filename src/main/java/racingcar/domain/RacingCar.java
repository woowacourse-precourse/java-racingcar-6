package racingcar.domain;

import racingcar.constant.ErrorMessage;

public final class RacingCar {

    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public RacingCar(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.toValue());
        }
    }
}
