package racingcar.util;

import java.util.List;

public class CarValidation {
    private CarValidation() {
    }

    public static void validateCars(List<String> carNames) {
        validateOverlap(carNames);
        validateMinSize(carNames);
    }


    public static void validateOverlap(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("이름들 간에 중복이 있습니다.");
        }
    }

    public static void validateMinSize(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException("자동차는 최소 2개가 필요합니다.");
        }
    }
}

