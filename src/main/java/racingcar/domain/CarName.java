package racingcar.domain;

import racingcar.exception.RacingCarException;

import static racingcar.exception.ErrorMessage.*;

public class CarName {
    private static final Integer NAME_LENGTH_CONSTRAINT = 5;

    private final String name;

    // Private CarName Constructor
    private CarName(final String name) {
        validateEmpty(name);
        validateContainWhiteSpace(name);
        validateExceedLength(name);

        this.name = name;
    }

    // Static Factory Method
    public static CarName create(final String name) {
        return new CarName(name);
    }

    /**
     * Exception Handling Method
     */
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
        if (isInValidLength(name)) {
            throw RacingCarException.of(TOO_LONG_NAME);
        }
    }

    /**
     * Validation Condition
     */
    private static boolean hasWhiteSpace(final String name) {
        return name.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isInValidLength(final String name) {
        return name.length() > NAME_LENGTH_CONSTRAINT;
    }

    /**
     * Getter
     */
    public String getName() {
        return name;
    }
}
