package racingcar.validation;

import racingcar.exception.InvalidBlankNameException;

import java.util.Arrays;

public class ValidateBlankNameFormat {
    public static void validate(String value) {
        String[] cars = value.split(",");
        Arrays.stream(cars).forEach(ValidateBlankNameFormat::checkBlank);
    }

    private static void checkBlank(String value) {
        if (value.isBlank()) {
            throw new InvalidBlankNameException();
        }
    }
}
