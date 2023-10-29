package racingcar.utils;

import java.util.List;

public class InputValidator {
    private InputValidator() {
    }

    public static void validateNumberOfCars(int sizeOfCarList) {
        if (sizeOfCarList < 1) {
            throw new IllegalArgumentException("1대 이상의 차량을 입력하세요.");
        }
    }

    public static void validateIsNamesDistinct(List<String> carNames) {
        if (carNames.stream().distinct().count() != carNames.size()) {
            throw new IllegalArgumentException("중복되지 않는 이름들을 입력하세요.");
        }
    }

    public static void validateNameLength(int nameLength) {
        if (nameLength < 1 || nameLength > 5) {
            throw new IllegalArgumentException("1자 이상, 5자이하의 이름을 입력하세요.");
        }
    }

}
