package racingcar.util.validate;

import racingcar.util.constant.ExceptionConstant;

import static racingcar.util.constant.ExceptionConstant.*;

public class InputValidate {

    static public void validateNameFormat(String input) {
        if(input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME);
        }
    }
    static public int validateInputNumberFormat(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_VALID_NUMBER);
        }
    }

    static public void validateInputNumberRange(int number) {
        if(number < 1) {
            throw new IllegalArgumentException(INPUT_VALID_NUMBER_RANGE);
        }
    }

    static public void validateNumberLength(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException(INPUT_VALID_NAME_LENGTH);
        }
    }
}
