package util.validator;

import static enums.ErrorMessages.*;

public final class StringLengthValidator {

    public static boolean validateMaxLength(String value,int maxValue) {
        if (value.length() > maxValue) {
            throw new IllegalArgumentException(MAX_LENGTH_ERROR.getMessage());
        }
        return true;
    }
}
