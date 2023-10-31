package racingcar.domain;

import static racingcar.constant.CarConstant.CAR_LIMIT_NAME_LENGTH;
import static racingcar.constant.CarConstant.CAR_NAME_SPLIT_STRING;
import static racingcar.exception.ErrorMessage.BLANK_NAME;
import static racingcar.exception.ErrorMessage.INVALID_NAME_LENGTH;
import static racingcar.exception.ErrorMessage.UNEXPECTED_STRING;

import racingcar.exception.RacingGameException;

public record Name(String name) {

    public Name {
        validate(name);
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw RacingGameException.of(BLANK_NAME);
        }

        if (name.contains(CAR_NAME_SPLIT_STRING)) {
            throw RacingGameException.of(UNEXPECTED_STRING);
        }

        if (name.length() > CAR_LIMIT_NAME_LENGTH) {
            throw RacingGameException.of(INVALID_NAME_LENGTH);
        }

    }
}
