package racingcar.domain;

import racingcar.global.exception.RacingCarException;

import java.util.Objects;

import static racingcar.global.exception.ErrorMessage.*;

public class CarNameValidator {
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";

    private CarNameValidator() {
    }

    public static void validateNull(final String input) {
        if (Objects.isNull(input)) {
            throw RacingCarException.of(NULL);
        }
    }

    public static void validateWhiteSpace(final String input) {
        if (hasWhiteSpace(input)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(COMMA)) {
            throw RacingCarException.of(ENDS_WITH_COMMA);
        }
    }

    public static void validateEndsWithTab(final String input) {
        if (input.endsWith(TAB)) {
            throw RacingCarException.of(ENDS_WITH_TAB);
        }
    }

    public static void validateEndsWithNewLine(final String input) {
        if (input.endsWith(NEW_LINE)) {
            throw RacingCarException.of(ENDS_WITH_NEW_LINE);
        }
    }

    private static boolean hasWhiteSpace(final String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }
}
