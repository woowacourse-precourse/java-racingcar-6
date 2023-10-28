package racingcar.utility;

import racingcar.global.exception.RacingCarException;

import java.util.List;
import java.util.Objects;

import static racingcar.global.GameConfig.NAME_MAXIMUM_CONSTRAINT;
import static racingcar.global.exception.ErrorMessage.*;

public class ConstraintValidator {
    private static final String COMMA = ",";
    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";

    private ConstraintValidator() {
    }

    public static void validateNull(final String input) {
        if (Objects.isNull(input)) {
            throw RacingCarException.of(NULL);
        }
    }

    public static void validateContainWhiteSpace(final String input) {
        if (hasWhiteSpace(input)) {
            throw RacingCarException.of(CONTAIN_IMPROPER_LETTER);
        }
    }

    public static void validateEndsWithComma(final String input) {
        if (input.endsWith(COMMA)) {
            throw RacingCarException.of(ENDS_WITH_COMMA);
        }
    }

    public static void validateContainTab(final String input) {
        if (input.endsWith(TAB)) {
            throw RacingCarException.of(ENDS_WITH_TAB);
        }
    }

    public static void validateContainNewLine(final String input) {
        if (input.endsWith(NEW_LINE)) {
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
