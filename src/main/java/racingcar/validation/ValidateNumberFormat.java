package racingcar.validation;

import racingcar.exception.InvalidBlankNameException;
import racingcar.exception.InvalidNumberFormatException;

import java.util.Arrays;

public class ValidateNumberFormat {
    public static void validate(String value) {
        if (!value.matches("^[1-9]+$")) {
            throw new InvalidNumberFormatException();
        }
    }
}
