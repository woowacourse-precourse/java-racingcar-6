package racingcar.validator;

import racingcar.constant.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.constant.ErrorMessage.ENTER_ONLY_NUMBER;
import static racingcar.constant.ErrorMessage.ENTER_PROPER_RANGE_NUMBER;


public class MoveNumberValidator {
    private static final Pattern numberPattern = Pattern.compile("\\d+");

    public static void validate(String moveNumber) {
        if (isNotNumber(moveNumber)) {
            throw new IllegalArgumentException(ENTER_ONLY_NUMBER);
        }
        if (outOfRange(moveNumber)) {
            throw new IllegalArgumentException(ENTER_PROPER_RANGE_NUMBER);
        }
    }

    private static boolean isNotNumber(String moveNumber) {
        Matcher matcher = numberPattern.matcher(moveNumber);
        return !matcher.matches();
    }

    private static boolean outOfRange(String moveNumber) {
        int number = Integer.parseInt(moveNumber);
        return number > 0 && number <= 10000;
    }
}
