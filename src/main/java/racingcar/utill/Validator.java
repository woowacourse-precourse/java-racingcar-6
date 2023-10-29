package racingcar.utill;

import static racingcar.utill.constant.ExceptionConstant.ATTEMPT_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.CAR_NAME_BLANK_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.CAR_NAME_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ExceptionConstant.NULL_INPUT_EXCEPTION_MESSAGE;
import static racingcar.utill.constant.ValidatorConstant.CAR_NAME_MAX_SIZE;
import static racingcar.utill.constant.ValidatorConstant.NATURAL_NUMBER_PATTERN;

import java.util.regex.Matcher;

public class Validator {

    public static void nullInputValidation(String nullString) {
        if (nullString == null) {
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION_MESSAGE);
        }
    }

    public static void carNameValidation(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_EXCEPTION_MESSAGE);
        }

        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
        }
    }

    public static void attemptNumberValidation(String attemptNumber) {
        Matcher attemptNumberMatcher = NATURAL_NUMBER_PATTERN.matcher(attemptNumber);
        if (!attemptNumberMatcher.matches()) {
            throw new IllegalArgumentException(ATTEMPT_NUMBER_EXCEPTION_MESSAGE);
        }
    }
}
