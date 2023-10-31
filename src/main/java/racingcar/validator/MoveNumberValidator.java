package racingcar.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static racingcar.constant.ConstantNumber.MAX_TRIAL_COUNT;
import static racingcar.constant.ErrorMessage.ENTER_ONLY_NATURAL_NUMBER;
import static racingcar.constant.ErrorMessage.ENTER_PROPER_RANGE_NUMBER;


public class MoveNumberValidator {

    private MoveNumberValidator() {}
    private static final Pattern numberPattern = Pattern.compile("[0-9]+");

    public static void validate(String moveNumber) {
        if (!isNumeric(moveNumber)) {
            throw new IllegalArgumentException(ENTER_ONLY_NATURAL_NUMBER);
        }
        if (isOutOfRange(moveNumber)) {
            throw new IllegalArgumentException(ENTER_PROPER_RANGE_NUMBER);
        }
    }

    private static boolean isNumeric(String moveNumber) {
        Matcher matcher = numberPattern.matcher(moveNumber);
        return matcher.matches();
    }

    private static boolean isOutOfRange(String moveNumber) {
        int number = Integer.parseInt(moveNumber);
        return number <= 0 || number > MAX_TRIAL_COUNT;
    }
}
