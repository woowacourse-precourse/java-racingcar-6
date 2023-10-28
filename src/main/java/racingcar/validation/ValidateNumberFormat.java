package racingcar.validation;

import racingcar.exception.InvalidBlankNameException;
import racingcar.exception.InvalidNumberFormatException;

import java.util.Arrays;

public class ValidateNumberFormat {
    public static void validate(String value) {
        if (!value.matches("^[0-9]+$") || Integer.parseInt(value) == 0) {
            throw new InvalidNumberFormatException();
        }
    }
}
