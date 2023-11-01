package racingcar.utils;

import racingcar.exceptions.runtime.InvalidNumberSourceException;

public class NumberStringConverter {

    private NumberStringConverter() {
    }

    public static Long convert(String number) {
        try {
            return Long.parseLong(number);
        } catch (NumberFormatException e) {
            throw new InvalidNumberSourceException();
        }
    }
}
