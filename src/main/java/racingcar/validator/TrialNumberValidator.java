package racingcar.validator;

import static racingcar.constant.MessageConstant.ERROR_MESSAGE_NUMBER_INPUT;
import static racingcar.constant.MessageConstant.ERROR_MESSAGE_NUMBER_TYPE;

public class TrialNumberValidator {

    public static void checkTrialNumberInput(String input) {
        checkEmpty(input);
        checkInputType(input);
    }

    private static void checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_INPUT);
        }
    }

    private static void checkInputType(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_TYPE);
        }
    }
}
