package util.validator;

import static enums.ErrorMessages.*;

public final class StringLengthValidator {

    private static final int MAX_LENGTH = 5;

    public static boolean validateMaxLength(String value) {
        if (value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH_ERROR.getMessage());
        }
        return true;
    }
}
