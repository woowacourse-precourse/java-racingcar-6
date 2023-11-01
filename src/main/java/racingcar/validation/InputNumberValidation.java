package racingcar.validation;

import static racingcar.constant.Number.MIN_TRY_NUMBER;
import static racingcar.constant.Validation.INPUT_NATURAL_NUMBER_VALIDATION;
import static racingcar.constant.Validation.INPUT_NUMBER_VALIDATION;

public class InputNumberValidation {

    public static void validation(String number) {
        numberValidation(number);
        naturalNumberValidatino(number);
    }

    public static void numberValidation(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(INPUT_NUMBER_VALIDATION);
        }
    }

    public static void naturalNumberValidatino(String number) {
        int attempNumber = Integer.parseInt(number);
        if (attempNumber < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException(INPUT_NATURAL_NUMBER_VALIDATION);
        }
    }

}
