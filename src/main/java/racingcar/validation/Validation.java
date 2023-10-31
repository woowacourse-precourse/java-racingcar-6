package racingcar.validation;

import racingcar.exception.SizeNotMatchException;

public class Validation {
    public static void carNameSizeCheck(String carName) {
        if (carName.length() < 1 || carName.length() > 4) {
            throw new SizeNotMatchException();
        }
    }
}
