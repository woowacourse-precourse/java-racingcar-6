package validation;

import static constant.Constant.NAME_LENGTH_LIMIT;
import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;

public class UserInputValidator {
    public static void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkEmptyInput(String part) {
        if (part.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_CASE_MESSAGE);
        }
    }
}