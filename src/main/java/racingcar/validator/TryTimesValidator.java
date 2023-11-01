package racingcar.validator;

import racingcar.exception.ExceptionMessage;

import java.util.regex.Pattern;

public class TryTimesValidator {

    private static final String regex = "^[1-9]\\d*$";

    private TryTimesValidator() {
        throw new AssertionError();
    }

    public static void validateNumber(String tryTimes) {
        if (!Pattern.matches(regex, tryTimes)) {
            throw ExceptionMessage.INPUT_FORMAT.getException();
        }
    }

}
