package racingcar.validator;

import racingcar.message.ErrorMessage;

import java.util.regex.Pattern;

public class InputValidator {
    private static final String REGEX = "^[0-9]+$";

    public void validateIsDigit(String number) {
        if (!Pattern.matches(REGEX, number)) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_DIGIT.toString());
        }
    }
}
