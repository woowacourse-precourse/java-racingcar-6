package validate;

import static constants.RacingCarErrorConstants.*;

public class InputValidation {

    public static void validateNumericInput(String input) {
        if (!input.matches("^[0-9]+$")){
            throw new IllegalArgumentException(NUMERIC_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validateInputLengthExceeded(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEEDED_ERROR_MESSAGE);
        }
    }

    public static void validateInputIsEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY_ERROR_MESSAGE);
        }
    }

    public static void validateInputDoesNotContainSpecialCharacters(String name) {
        if (name.matches(".*[ !@#$%^&*(),.?\":{}|<>].*")) {
            throw new IllegalArgumentException(INPUT_DOES_NOT_CONTAIN_SPECIAL_CHARACTERS_ERROR_MESSAGE);
        }
    }

    public static void validateListIsEmpty(String[] list) {
        if (list.length == 0) {
            throw new IllegalArgumentException(LIST_IS_EMPTY_ERROR_MESSAGE);
        }
    }
}
