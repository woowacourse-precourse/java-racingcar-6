package racingcar.exception;

import racingcar.util.CarNameValidatorConstant;

public class CarNameValidator {

    public static void validate(String name) {
        if (name == null || name.length() > CarNameValidatorConstant.MAX_NAME_LENGTH || name.length() < CarNameValidatorConstant.MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}