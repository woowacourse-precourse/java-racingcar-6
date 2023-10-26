package racingcar.domain;

import static racingcar.util.ErrorMessage.*;

public record Name(String value) {

    private static final String NUMBER_REGEX = "^[0-9]*$";

    public Name {
        validateName(value);
    }

    private void validateName(String name) {
        checkBlank(name);
        checkLength(name);
        checkNumeric(name);
    }

    private void checkBlank(String name) {
        if (name.isBlank() || name.isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR.getMessage());
        }
    }

    private void checkLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(LENGTH_ERROR.getMessage());
        }
    }

    private void checkNumeric(String name) {
        if (name.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(NO_NUMERIC_ERROR.getMessage());
        }
    }
}
