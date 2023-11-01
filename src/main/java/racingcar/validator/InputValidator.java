package racingcar.validator;

import racingcar.message.ExceptionMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String DIGIT_REGEX = "^[0-9]+$";
    private static final String SPLIT_REGEX = "^[ㄱ-힣a-zA-Z0-9,]+$";

    public void validateIsDigit(String number) {
        if (!Pattern.matches(DIGIT_REGEX, number)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_DIGIT.toString());
        }
    }

    public void validateIsSplitByComma(String input) {
        if (!Pattern.matches(SPLIT_REGEX, input)) {
            throw new IllegalArgumentException(ExceptionMessage.IS_NOT_RIGHT_PATTERN.toString());
        }
    }
}
