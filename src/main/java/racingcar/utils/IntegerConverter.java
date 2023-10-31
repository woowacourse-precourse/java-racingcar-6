package racingcar.utils;

import static racingcar.utils.ErrorMessages.NOT_INTEGER_TYPE;

public class IntegerConverter {
    public static int convert(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_TYPE);
        }
    }
}
