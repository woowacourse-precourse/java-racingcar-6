package racingcar.validation;

import java.util.regex.Pattern;
import racingcar.exception.NotNatureNumberException;
import racingcar.exception.SizeNotMatchException;

public class Validation {
    private static final String NATURE_NUMBER = "^[1-9][0-9]*$";

    public static void carNameSizeCheck(String carName) {
        if (carName.length() < 1 || carName.length() > 4) {
            throw new SizeNotMatchException();
        }
    }

    public static void checkNatureNumber(String tryNumber) {
        if (!Pattern.matches(NATURE_NUMBER, tryNumber)) {
            throw new NotNatureNumberException();
        }
    }
}
