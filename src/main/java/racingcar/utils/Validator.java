package racingcar.utils;

import java.util.List;

public class Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MINIMUM_REQUIRED_CARS = 2;
    private static final int MINIMUM_REQUIRED_ATTEMPTS = 1;
    private static final String ERROR_NOT_ENOUGH_PLAYER = "경주할 차는 " + MINIMUM_REQUIRED_CARS + "대 이상이어야 합니다.";
    private static final String ERROR_INVALID_NAME_LENGTH = "자동차 이름은 " + MAX_CAR_NAME_LENGTH + "글자 이하여야 합니다.";
    private static final String ERROR_INVALID_ATTEMPTS = "시도 횟수는 " + MINIMUM_REQUIRED_ATTEMPTS + " 이상이어야 합니다.";

    private Validator() {
        throw new AssertionError();
    }

    public static void validateCarNames(List<String> carNames) {
        validateMinimumCarCount(carNames);
        validateCarNameLength(carNames);
    }

    private static void validateMinimumCarCount(List<String> carNames) {
        if (carNames.size() < MINIMUM_REQUIRED_CARS) {
            throw new IllegalArgumentException(ERROR_NOT_ENOUGH_PLAYER);
        }
    }

    private static void validateCarNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ERROR_INVALID_NAME_LENGTH);
            }
        }
    }

    public static void validateAttemptsNumber(int attempts) {
        if (attempts < MINIMUM_REQUIRED_ATTEMPTS) {
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPTS);
        }
    }
}
