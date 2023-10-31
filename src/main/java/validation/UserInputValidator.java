package validation;

import static constant.Constant.NAME_LENGTH_LIMIT;
import static constant.ErrorMessage.EMPTY_NAME_CASE_MESSAGE;
import static constant.ErrorMessage.EXCEED_NAME_CASE_MESSAGE;

public class UserInputValidator {

    public static void validateInput(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(EXCEED_NAME_CASE_MESSAGE);
        } if (name.isBlank()) {
            throw new IllegalArgumentException(EMPTY_NAME_CASE_MESSAGE);
        }
    }
}