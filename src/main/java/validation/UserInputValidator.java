package validation;

import static constant.Constant.NAME_LENGTH_LIMIT;

public class UserInputValidator {
    public static void checkNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }
}