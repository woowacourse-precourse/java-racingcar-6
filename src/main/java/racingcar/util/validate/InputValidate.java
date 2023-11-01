package racingcar.util.validate;

import static racingcar.util.constant.ExceptionConstant.*;

public class InputValidate {

    static public void validateNameFormat(String input) {
        if (input.isEmpty() || input.equals(",")) {
            throw new IllegalArgumentException(EMPTY_NAME);
        } else if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_INPUT_NAME);
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
        if (number < MINIMUM_NUMBER_VALUE || number > MAXIMUM_NUMBER_VALUE) {
            throw new IllegalArgumentException(INPUT_VALID_NUMBER_RANGE);
        }
    }

    static public void validateNumberLength(String name) {
        if (name.length() > MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INPUT_VALID_NAME_LENGTH);
        }
    }

    static public void validateUsernameStartsWithBlank(String name) {
        if (name.startsWith(" ")) {
            throw new IllegalArgumentException(INPUT_NAME_NOT_STARTS_WITH_EMPTY);
        }
    }

    static public String validatePrintWinners(String winnerList) {
        if (!winnerList.contains(", ")) {
            throw new IllegalArgumentException(MORE_THAN_TWO_WINNERS);
        }
        return winnerList;
    }
}
