package racingcar.validation;

import racingcar.exception.InvalidDuplicatedNamesException;

import java.util.Arrays;

public class ValidateDuplicatedName {
    public static void validate(String value) {
        String[] cars = value.split(",");
        checkDupllicatedName(cars);
    }

    private static void checkDupllicatedName(String[] cars) {
        if (cars.length != Arrays.stream(cars).distinct().count()) {
            throw new InvalidDuplicatedNamesException();
        }
    }
}
