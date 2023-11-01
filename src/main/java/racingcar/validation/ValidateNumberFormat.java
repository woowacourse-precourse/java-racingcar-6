package racingcar.validation;

import racingcar.exception.InvalidNumberFormatException;


public class ValidateNumberFormat {
    public static void validate(String value) {
        if (!value.matches("^[0-9]+$") || Integer.parseInt(value) == 0) {
            throw new InvalidNumberFormatException();
        }
    }
}
