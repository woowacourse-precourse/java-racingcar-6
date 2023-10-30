package racingcar;

import java.util.List;

public class Validator {
    public static void validateCars(List<String> cars) {
        validateListNotEmpty(cars);
        long distinctCars = cars.stream()
                .distinct()
                .peek(Validator::validateCarName)
                .count();
        validateCarDistinct(cars.size(), distinctCars);
    }

    private static void validateListNotEmpty(List<String> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("입력된 자동차가 없습니다.");
        }
    }

    private static void validateCarName(String carName) {
        validateCarNameFormat(carName);
        validateCarNameFilled(carName);
        validateCarNameLength(carName);
    }

    private static void validateCarNameFormat(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("이름이 입력되지 않은 자동차가 있습니다.");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘을 수 없습니다.");
        }
    }

    private static void validateCarNameFilled(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("이름에 공백이 포함된 자동차가 있습니다.");
        }
    }

    private static void validateCarDistinct(int cars, long distinctCars) {
        if (cars != distinctCars) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
