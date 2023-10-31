package validation;

import static constant.Constant.NAME_LENGTH_LIMIT;
import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.EXCEED_NAME_CASE_MESSAGE;

public class UserInputValidator {

    public static void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEED_NAME_CASE_MESSAGE);
        }
    }

    public static void validateEmptyInput(String part) {
        if (part.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_CASE_MESSAGE);
        }
    }
}