package racingcar.domain;

import racingcar.exception.RacingCarException;

import java.util.List;

import static racingcar.configuration.GameConfiguration.NAME_MAXIMUM_CONSTRAINT;
import static racingcar.exception.ErrorMessage.*;

public class CarName {
    private static final String DELIMITER = ",";

    private final String name;

    private CarName(final String name) {
        validateEmpty(name);
        validateContainWhiteSpace(name);
        validateEndsWithDelimiter(name);
        this.name = name;
    }

    public static CarName create(final String name) {
        return new CarName(name);
    }

    public static void validateEmpty(final String input) {
        if (input.isEmpty()) {
            throw RacingCarException.of(EMPTY);
        }
    }

    public static void validateContainWhiteSpace(final String input) {
        if (hasWhiteSpace(input)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    public static void validateEndsWithDelimiter(final String input) {
        if (input.endsWith(DELIMITER)) {
            throw RacingCarException.of(ENDS_WITH_DELIMITER);
        }
    }

    private static boolean hasWhiteSpace(final String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isInValidNameLength(final List<String> inputs) {
        return inputs.stream()
                .anyMatch(input -> input.length() > NAME_MAXIMUM_CONSTRAINT.getValue());
    }
}
