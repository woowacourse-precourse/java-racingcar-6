package racingcar.exception;

import racingcar.util.Constants;

public class CarNameValidator {

    public static void validate(String name) {
        if (name == null || name.length() > Constants.MAX_NAME_LENGTH || name.length() < Constants.MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}