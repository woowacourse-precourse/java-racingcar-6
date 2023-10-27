package racingcar.utill;

import static racingcar.utill.ValidatorConstant.CAR_NAME_MAX_SIZE;
import static racingcar.utill.ValidatorConstant.NATURAL_NUMBER_PATTERN;

import java.util.regex.Matcher;
import racingcar.utill.exception.AttemptNumberException;
import racingcar.utill.exception.CarNameException;

public class Validator {

    public static void carNameValidation(String carName) {
        if (carName.isEmpty()) {
            throw new CarNameException();
        }
        if (carName.length() > CAR_NAME_MAX_SIZE) {
            throw new CarNameException(carName);
        }
    }

    public static void attemptNumberValidation(String attemptNumber) {
        Matcher attemptNumberMatcher = NATURAL_NUMBER_PATTERN.matcher(attemptNumber);
        if (!attemptNumberMatcher.matches()) {
            throw new AttemptNumberException(attemptNumber);
        }
    }
}
