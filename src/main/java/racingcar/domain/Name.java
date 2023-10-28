package racingcar.domain;

import racingcar.exception.RacingCarException;

import static racingcar.exception.ErrorMessage.*;

public class Name {
    private static final Integer NAME_LENGTH_UPPER_BOUND_CONSTRAINT = 5;

    private final String name;

    private Name(final String name) {
        validateEmpty(name);
        validateContainWhiteSpace(name);
        validateExceedLength(name);

        this.name = name;
    }

    public static Name create(final String name) {
        return new Name(name);
    }

    private static void validateEmpty(final String name) {
        if (name.isEmpty()) {
            throw RacingCarException.of(EMPTY);
        }
    }

    private static void validateContainWhiteSpace(final String name) {
        if (hasWhiteSpace(name)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    private static void validateExceedLength(final String name) {
        if (isExceedLength(name)) {
            throw RacingCarException.of(TOO_LONG_NAME);
        }
    }

    private static boolean hasWhiteSpace(final String name) {
        return name.chars().anyMatch(Character::isWhitespace);
    }


    private static boolean isExceedLength(final String name) {
        return name.length() > NAME_LENGTH_UPPER_BOUND_CONSTRAINT;
    }

    public String getName() {
        return name;
    }
}
