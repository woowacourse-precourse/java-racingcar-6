package racingcar.domain;

import static racingcar.exception.ErrorMessage.BLANK_NAME;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;

import racingcar.exception.RacingGameException;

public record Name(String name) {

    public static final int CAR_LIMIT_NAME_LENGTH = 5;

    public Name {
        validate(name);
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw RacingGameException.of(BLANK_NAME);
        }

        if (name.length() > CAR_LIMIT_NAME_LENGTH) {
            throw RacingGameException.of(INVALID_NAME_LENGTH);
        }

    }
}
