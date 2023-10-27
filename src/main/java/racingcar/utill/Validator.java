package racingcar.utill;

import static racingcar.utill.ExceptionConstant.ATTEMPT_NUMBER_EXCEPTION_MESSAGE;
import static racingcar.utill.ExceptionConstant.CAR_NAME_EXCEPTION_MESSAGE;
import static racingcar.utill.ValidatorConstant.CAR_NAME_MAX_SIZE;
import static racingcar.utill.ValidatorConstant.NATURAL_NUMBER_PATTERN;

import java.util.regex.Matcher;

public class Validator {

    public static void carNameValidation(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EXCEPTION_MESSAGE);
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
