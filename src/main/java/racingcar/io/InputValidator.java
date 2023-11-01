package racingcar.io;

import racingcar.constant.Delimiter;
import racingcar.constant.ErrorMessage;

public class InputValidator {

    public void validateRacingCarNames(final String input) {
        if (hasInvalidDelimiterUsage(input) || hasInvalidBlankUsage(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_INPUT.toValue());
        }
    }

    private boolean hasInvalidDelimiterUsage(final String input) {
        final String comma = Delimiter.COMMA.toExpression();

        return input.startsWith(comma)
                || input.endsWith(comma)
                || input.contains(Delimiter.DOUBLE_COMMA.toExpression());
    }

    private boolean hasInvalidBlankUsage(final String input) {
        final String blank = Delimiter.BLANK.toExpression();

        return input.startsWith(blank)
                || input.endsWith(blank)
                || input.contains(Delimiter.BLANK_AFTER_COMMA.toExpression())
                || input.contains(Delimiter.BLANK_BEFORE_COMMA.toExpression());
    }

    public void validateTryCount(final String input) {
        if (hasNonNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.toValue());
        }
    }

    private boolean hasNonNumeric(final String input) {
        return !input.chars().allMatch(Character::isDigit);
    }
}
