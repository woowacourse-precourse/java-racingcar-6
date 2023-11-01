package racingcar.controller;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 자동차 이름 유효성 검사를 담당합니다.
 */
public class CarNameValidator {
    private static final String CAR_NAME_PATTERN = "^\\S{0,5}$";

    private static final String CAR_NAME_ERROR_MESSAGE = "잘못된 자동차 이름입니다.";

    private static final int MINIMUM_CARS_COUNT = 2;

    public static void validate(List<String> carNames) {
        if (isNullCarNameExists(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }

        if (isDuplicatedCarNameExists(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }

        if (isLessThanMinimumCarsCount(carNames)) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }

        for (String carName : carNames) {
            if (!isValidCarNamePattern(carName)) {
                throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE + carName);
            }
        }
    }

    private static boolean isValidCarNamePattern(String carName) {
        if (carName == null) {
            return false;
        }

        Pattern pattern = Pattern.compile(CAR_NAME_PATTERN);
        Matcher matcher = pattern.matcher(carName);
        return matcher.matches();
    }

    private static boolean isDuplicatedCarNameExists(List<String> carNames) {
        return carNames.size() != carNames.stream().distinct().count();
    }

    private static boolean isNullCarNameExists(List<String> carNames) {
        return carNames.stream().anyMatch(Objects::isNull);
    }

    private static boolean isLessThanMinimumCarsCount(List<String> carNames) {
        return carNames.size() < MINIMUM_CARS_COUNT;
    }
}
