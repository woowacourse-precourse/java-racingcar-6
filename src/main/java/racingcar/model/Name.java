package racingcar.model;

import static racingcar.ExceptionMessage.NAME_VALUE_BLANK_EXCEPTION;

public class Name {

    private static final int MINIMUM_LENGTH = 1;
    private static final int MAXIMUM_LENGTH = 5;

    private final String name;

    private Name(final String name) {
        this.name = name;
    }

    public static Name from(final String name) {
        validate(name);
        return new Name(name);
    }

    private static void validate(final String name) {
        if (name.length() < MINIMUM_LENGTH || name.length() > MAXIMUM_LENGTH) {
            throw new IllegalArgumentException("이름 길이는 " + MINIMUM_LENGTH + "자 이상 "
                    + MAXIMUM_LENGTH + "자 이하여야 합니다.");
        }

        if (name.contains(" ")) {
            throw new IllegalArgumentException(NAME_VALUE_BLANK_EXCEPTION.getMessage());
        }
    }

    public String getName() {
        return name;
    }
}
