package racingcar.utils;

import racingcar.constant.ValidatorConstant;

public class CarNameValidator {
    public static void validateCarName(String name) {
        if (name == null || name.length() > ValidatorConstant.MAX_NAME_LENGTH || name.length() < ValidatorConstant.MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
