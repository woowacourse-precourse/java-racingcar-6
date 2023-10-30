package racingcar.utils;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private InputValidator() {
    }

    private static final String INPUT_MIN_CARS = "최소한 %d개 이상의 자동차 이름을 입력하세요.";
    private static final String INVALID_CAR_NAME = "자동차 이름은 영문 알파벳으로만 작성해주세요.";
    private static final String INVALID_CAR_NAME_SIZE = "자동차 이름은 %d자 이하만 가능합니다.";
    private static final Pattern CAR_NAME_REGEX = Pattern.compile("^[a-zA-Z]+$");
    private static final int MIN_CARS = 2;
    private static final int MAX_CAR_NAME_SIZE = 5;

    public static void validateMinCars(List<String> carNames) {
        if (carNames.size() < MIN_CARS) {
            throw new IllegalArgumentException(String.format(INPUT_MIN_CARS, MIN_CARS));
        }
    }

    public static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
            validateCarNameSize(carName);
        }
    }

    private static void validateCarName(String carName) {
        if (!CAR_NAME_REGEX.matcher(carName).matches()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }

    public static void validateCarNameSize(String carName) {
        if (carName.length() > MAX_CAR_NAME_SIZE) {
            throw new IllegalArgumentException(String.format(INVALID_CAR_NAME_SIZE, MAX_CAR_NAME_SIZE));
        }
    }
}
