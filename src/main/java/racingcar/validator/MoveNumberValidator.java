package racingcar.validator;

import org.mockito.internal.matchers.GreaterThan;
import racingcar.constant.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.constant.ErrorMessage.ENTER_ONLY_NUMBER;
import static racingcar.constant.ErrorMessage.ENTER_PROPER_RANGE_NUMBER;


public class MoveNumberValidator {
    private static final Pattern numberPattern = Pattern.compile("[0-9]+");

    public static void validate(String moveNumber) {
        if (!isNumeric(moveNumber)) {
            throw new IllegalArgumentException(ENTER_ONLY_NUMBER);
        }
        if (outOfRange(moveNumber)) {
            throw new IllegalArgumentException(ENTER_PROPER_RANGE_NUMBER);
        }
    }

    private static boolean isNumeric(String moveNumber) {
        return moveNumber.matches("[0-9]+");
    }

    private static boolean outOfRange(String moveNumber) {
        int number = Integer.parseInt(moveNumber);
        return number <= 0 || number > 10000;
    }
}
