package racingcar.util;

import racingcar.constant.CycleExceptionMessage;

public class CycleInputValidator {

    private CycleInputValidator() {
    }

    public static void validate(String input) {
        inputNotEmptyValidate(input);
        integerValidate(input);
        naturalNumberValidate(input);
    }

    private static void inputNotEmptyValidate(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(CycleExceptionMessage.EMPTY_INPUT.getMessage());
        }
    }

    private static void integerValidate(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CycleExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }

    private static void naturalNumberValidate(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(CycleExceptionMessage.NOT_NATURAL_NUMBER.getMessage());
        }
    }
}
