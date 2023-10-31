package racingcar.controller;

import java.util.List;
import racingcar.model.CarNameLength;
import racingcar.model.ErrorMessage;

public class Validator {

    public static void inputNumberValidator(final String num) {
        final String REGEX = "[0-9]+";
        if (!num.matches(REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }
}
