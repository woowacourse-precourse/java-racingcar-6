package racingcar.utils;

import racingcar.constant.ValidatorConstant;

public class NumberValidator {
    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name == null || name.trim().isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException(ValidatorConstant.CAR_NAME_LENGTH_MESSAGE);
            }
        }
    }

    public static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException(ValidatorConstant.ATTEMPT_NUMBER_ERROR_MESSAGE);
        }
    }
}
