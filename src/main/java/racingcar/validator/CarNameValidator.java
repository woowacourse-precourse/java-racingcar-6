package racingcar.validator;

import racingcar.domain.car.Car;

import java.util.List;

public class CarNameValidator {

    public static void validateForInputString(String carNames) {
        validateEmptyForInputString(carNames);
        validateContainsCommaForInputString(carNames);
    }

    private static void validateEmptyForInputString(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력값은 비어있지 않아야 합니다.");
        }
    }

    private static void validateContainsCommaForInputString(String carNames) {
        if (!carNames.contains(",")) {
            throw new IllegalArgumentException("입력값은 쉼표(,)를 기준으로 구분되어야 합니다.");
        }
    }

    public static void validateDuplicateForList(List<Car> cars) {
        if (cars.stream()
                .distinct()
                .count() != cars.size()) {
            throw new IllegalArgumentException("각각의 자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateForEachName(String carName) {
        validateEmptyForEachName(carName);
        validateLengthForEachName(carName);
    }

    private static void validateEmptyForEachName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름은 비어있지 않아야 합니다.");
        }
    }

    private static void validateLengthForEachName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 5 이하이어야 합니다.");
        }
    }
}
