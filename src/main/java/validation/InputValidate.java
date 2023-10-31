package validation;

import java.util.List;

public class InputValidate {
    private final static int MAX_LENGTH = 5;
    public static void carNames(List<String> names) {
    }

    private static void validateCarNameLength(String name) {
        if(name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_ERROR.getMessage());
        }
    }

}
