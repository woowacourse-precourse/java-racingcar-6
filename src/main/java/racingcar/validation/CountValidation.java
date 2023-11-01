package racingcar.validation;

import static racingcar.constant.IllegalArgumentMessage.COUNT_NOT_INTEGER;
import static racingcar.constant.IllegalArgumentMessage.COUNT_NOT_POSITIVE;

public class CountValidation {

    private CountValidation() {
    }

    public static void validate(String input) {
        int number = isInteger(input);
        isPositive(number);
    }

    private static Integer isInteger(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COUNT_NOT_INTEGER.getMessage());
        }
        return number;
    }

    private static void isPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(COUNT_NOT_POSITIVE.getMessage());
        }
    }

}
