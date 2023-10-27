package racingcar.domain;

import static racingcar.util.ExceptionMessage.CHECK_NAME_EMPTY;
import static racingcar.util.ExceptionMessage.CHECK_NAME_LENGTH;

public class Name {

    public static final int NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        checkEmpty(name);
        checkLength(name);
    }

    private void checkEmpty(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(CHECK_NAME_EMPTY.getMessage());
        }
    }

    private static void checkLength(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(CHECK_NAME_LENGTH.getMessage());
        }
    }

    public String getValue() {
        return this.name;
    }
}
