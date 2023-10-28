package racingcar.validator;

import racingcar.exception.RacingCarException;

import java.util.List;

import static racingcar.configuration.GameConfiguration.NAME_MAXIMUM_CONSTRAINT;
import static racingcar.exception.ErrorMessage.*;

public class ConstraintValidator {
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";

    private ConstraintValidator() {
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

    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(COMMA)) {
            throw RacingCarException.of(ENDS_WITH_DELIMITER);
        }
    }

    public static void validateContainTab(final String input) {
        if (input.contains(TAB)) {
            throw RacingCarException.of(CONTAIN_TAB);
        }
    }

    public static void validateContainNewLine(final String input) {
        if (input.contains(NEW_LINE)) {
            throw RacingCarException.of(ENDS_WITH_NEW_LINE);
        }
    }

    public static void validateNumber(final String input) {
        if (isInvalidNumber(input)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    public static void validateNameLength(final List<String> inputs) {
        if (isInValidNameLength(inputs)) {
            throw RacingCarException.of(TOO_LONG_INPUT);
        }
    }

    private static boolean hasWhiteSpace(final String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isInValidNameLength(final List<String> inputs) {
        return inputs.stream()
                .anyMatch(input -> input.length() > NAME_MAXIMUM_CONSTRAINT.getValue());
    }

    private static boolean isInvalidNumber(final String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
