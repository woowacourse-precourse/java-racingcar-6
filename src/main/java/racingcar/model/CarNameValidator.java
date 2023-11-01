package racingcar.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNameValidator {

    public static void validateCarNames(List<Car> carList) {
        validateNameSize(carList);
        validateDuplicateNames(carList);
        validateBlankOrEmptyNames(carList);
    }

    private static void validateNameSize(List<Car> carList) {
        if (carList.stream().anyMatch(car -> car.getName().length() > 5)) {
            throw new IllegalArgumentException("자동차 이름은 5글자가 넘으면 안됩니다.");
        }
    }

    private static void validateDuplicateNames(List<Car> carList) {
        Set<String> carNames = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carNames.size() != carList.size()) {
            throw new IllegalArgumentException("자동차의 이름이 중복되면 안됩니다.");
        }
    }

    private static void validateBlankOrEmptyNames(List<Car> carList) {
        if (carList.stream().anyMatch(car -> car.getName().isBlank())) {
            throw new IllegalArgumentException("자동차의 이름에 공백이 들어가면 안됩니다.");
        }
    }
}
