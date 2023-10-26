package validator;

import static constant.ConstantString.MAX_NAME_LENGTH;
import static constant.ExceptinoString.EMPTY_NAME_MESSAGE;
import static constant.ExceptinoString.MAX_LENGTH_EXCEEDED_MESSAGE;

public class NameValidator {
    private NameValidator() {
    }

    public static void validateCarName(String name) {
        isNameEmpty(name);
        isNameLengthExceeded(name);
    }

    private static void isNameLengthExceeded(String name) throws IllegalArgumentException {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH_EXCEEDED_MESSAGE);
        }
    }

    private static void isNameEmpty(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
        }
    }

    private static void isNameDuplicate(String name) {

    }
}
