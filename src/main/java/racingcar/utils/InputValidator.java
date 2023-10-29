package racingcar.utils;

import java.util.List;

public class InputValidator {

    private InputValidator() {
    }

    private static final String INPUT_MIN_CARS = "최소한 2개 이상의 자동차 이름을 입력하세요.";
    private static final String INVALID_CAR_NAME = "자동차 이름은 영문 알파벳으로만 작성해주세요.";
    private static final String INVALID_CAR_NAME_SIZE = "자동차 이름은 5자 이하만 가능합니다.";

    public static void validateMinCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(INPUT_MIN_CARS);
        }
    }

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
            validateCarNameSize(carName);
        }
    }

    private static void validateCarName(String carName) {
        if (!carName.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }

    public static void validateCarNameSize(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_SIZE);
        }
    }
}
