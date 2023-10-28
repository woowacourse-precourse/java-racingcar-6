package racingcar.domain;

import racingcar.exception.RacingCarException;

import static racingcar.exception.ErrorMessage.*;

public class CarName {
    private static final Integer NAME_LENGTH_CONSTRAINT = 5;

    private final String name;

    /**
     * Define Constructor
     */
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
     * Validate Empty
     */
    private static void validateEmpty(final String name) {
        if (name.isEmpty()) {
            throw RacingCarException.of(EMPTY);
        }
    }


    /**
     * Validate Contain WhiteSpace
     */
    private static void validateContainWhiteSpace(final String name) {
        if (hasWhiteSpace(name)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    private static boolean hasWhiteSpace(final String name) {
        return name.chars().anyMatch(Character::isWhitespace);
    }


    /**
     * Validate Exceed Length
     */
    private static void validateExceedLength(final String name) {
        if (isExceedLength(name)) {
            throw RacingCarException.of(TOO_LONG_NAME);
        }
    }

    private static boolean isExceedLength(final String name) {
        return name.length() > NAME_LENGTH_CONSTRAINT;
    }

    /**
     * Getter Method
     */
    public String getName() {
        return name;
    }
}
