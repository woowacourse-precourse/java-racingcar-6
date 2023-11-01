package racingcar.model;

import java.util.List;

public class CarNameValidator {
    private static final String INPUT_HAS_ONLY_ONE_CAR = "입력 값에 자동차가 한 대만 존재합니다.";
    private static final String INPUT_HAS_SPACE = "입력 값에 스페이스 값이 존재합니다.";
    private static final String INPUT_HAS_ZERO_LENGTH = "입력 값에 길이가 0인 자동차가 존재합니다.";
    private static final String INPUT_HAS_OVER_FIVE_LENGTH = "입력 값에 길이가 5가 넘는 자동차가 존재합니다.";
    private static final String INPUT_HAS_DUPLICATED_NAME = "입력 값에 중복 값이 존재합니다.";
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final int CAR_NAME_MIN_LENGTH = 1;
    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static List<String> carName;

    public static List<String> validateCarName(String carNames) {
        if (!hasMoreThanOneCar(carNames)) {
            throw new IllegalArgumentException(INPUT_HAS_ONLY_ONE_CAR);
        }
        if (hasSpace(carNames)) {
            throw new IllegalArgumentException(INPUT_HAS_SPACE);
        }
        carName = convertCarName(carNames);
        if (hasZeroLength(carName)) {
            throw new IllegalArgumentException(INPUT_HAS_ZERO_LENGTH);
        }
        if (hasOverFiveLength(carName)) {
            throw new IllegalArgumentException(INPUT_HAS_OVER_FIVE_LENGTH);
        }
        if (hasDuplicatedName(carName)) {
            throw new IllegalArgumentException(INPUT_HAS_DUPLICATED_NAME);
        }
        return carName;
    }

    private static List<String> convertCarName(String carNames) {
        return List.of(carNames.split(COMMA));
    }

    private static boolean hasMoreThanOneCar(String carNames) {
        return carNames.contains(COMMA);
    }

    private static boolean hasSpace(String carNames) {
        return carNames.contains(SPACE);
    }

    private static boolean hasZeroLength(List<String> carNames) {
        return carNames.stream()
                .anyMatch(car -> car.length() < CAR_NAME_MIN_LENGTH);
    }

    private static boolean hasOverFiveLength(List<String> carNames) {
        return carNames.stream()
                .anyMatch(car -> car.length() > CAR_NAME_MAX_LENGTH);
    }

    private static boolean hasDuplicatedName(List<String> carNames) {
        return carNames.stream()
                .distinct()
                .count() != carNames.size();
    }
}