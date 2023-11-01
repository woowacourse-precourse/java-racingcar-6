package racingcar.model;

import static racingcar.utils.Constants.BLANK_ERROR_MESSAGE;
import static racingcar.utils.Constants.DUPLICATION_ERROR_MESSAGE;
import static racingcar.utils.Constants.MAX_LENGTH;
import static racingcar.utils.Constants.SIZE_ERROR_MESSAGE;

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
        if (carList.stream().anyMatch(car -> car.getName().length() > MAX_LENGTH)) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateDuplicateNames(List<Car> carList) {
        Set<String> carNames = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toSet());

        if (carNames.size() != carList.size()) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }

    private static void validateBlankOrEmptyNames(List<Car> carList) {
        if (carList.stream().anyMatch(car -> car.getName().isBlank())) {
            throw new IllegalArgumentException(BLANK_ERROR_MESSAGE);
        }
    }
}
