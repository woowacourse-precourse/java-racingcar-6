package racingcar.validation;

import static racingcar.constant.Constant.ERROR_COUNT_NOT_POSITIVE_MESSAGE;

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
                throw new IllegalArgumentException(ERROR_COUNT_NOT_POSITIVE_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_COUNT_NOT_POSITIVE_MESSAGE);
        }
    }

}
