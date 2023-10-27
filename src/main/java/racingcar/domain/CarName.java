package racingcar.domain;

import static racingcar.util.ExceptionMessage.CHECK_NUMBERS_LENGTH;

public class CarName {

    private static final int NAME_LENGTH = 5;

    private final String name;

    public CarName(String name) {
        validateCarName(name);
        this.name = name;
    }

    private void validateCarName(String name) {
        if (name.length() > NAME_LENGTH) {
            throw new IllegalArgumentException(CHECK_NUMBERS_LENGTH.getMessage());
        }
    }

    public String getValue() {
        return this.name;
    }
}
