package racingcar.validation;

import static racingcar.constant.IllegalArgumentMessage.COUNT_NOT_POSITIVE;

public final class CountValidation extends InputValidation {

    private CountValidation() {
    }

    public static void validate(String input) {
        isEmptyInput(input);
        isNumeric(input);
    }

    private static void isNumeric(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) {
                throw new IllegalArgumentException(COUNT_NOT_POSITIVE.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(COUNT_NOT_POSITIVE.getMessage());
        }
    }

}
