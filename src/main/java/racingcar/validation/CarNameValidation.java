package racingcar.validation;

import static racingcar.constant.Number.MIN_CARS;
import static racingcar.constant.Validation.CARS_COUNT_VALIDATION;
import static racingcar.constant.Validation.COMMA_VALIDATION;
import static racingcar.constant.Validation.NAME_DUPLICATE_VALIDATION;

import java.util.Arrays;

public class CarNameValidation {

    public static void validation(String names) {
        commaValidate(names);
        String[] nameArray = names.split(",");
        dupliateNameValidation(nameArray);
        nameLengthValidation(nameArray);
    }

    private static void commaValidate(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException(COMMA_VALIDATION);
        }
    }

    private static void dupliateNameValidation(String[] nameArray) {
        if (Arrays.asList(nameArray).stream().distinct().count() != nameArray.length) {
            throw new IllegalArgumentException(NAME_DUPLICATE_VALIDATION);
        }
    }

    private static void nameLengthValidation(String[] nameArray) {
        if (nameArray.length < MIN_CARS) {
            throw new IllegalArgumentException(CARS_COUNT_VALIDATION);
        }
    }
}
