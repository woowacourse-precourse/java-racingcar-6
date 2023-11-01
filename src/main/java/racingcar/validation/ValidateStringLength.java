package racingcar.validation;

import racingcar.exception.InvalidNameLengthException;

import java.util.Arrays;

public class ValidateStringLength {

    public static void validate(String value) {
        String[] cars = value.split(",");
        Arrays.stream(cars).forEach(ValidateStringLength::checkLength);
    }

    private static void checkLength(String value) {
        if (value.length() > 5) {
            throw new InvalidNameLengthException();
        }
    }
}
