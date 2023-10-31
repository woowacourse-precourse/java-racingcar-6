package racingcar.domain;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameCondition;
import racingcar.enums.RegexPattern;

public class RacingCars {
    private final List<Car> cars;
    private static final Pattern CAR_NAME_REGEX = Pattern.compile(RegexPattern.CAR_NAME.getPattern());
    private static String message = "";

    public RacingCars(final List<String> carNames) {
        validateMinCars(carNames);
        validateCarNames(carNames);
        this.cars = convertStringToCar(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> convertStringToCar(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private static void validateMinCars(List<String> carNames) {
        int minCars = GameCondition.MIN_CARS.getValue();
        message = ErrorMessage.INVALID_MIN_CARS.getMessage();
        if (carNames.size() < minCars) {
            throw new IllegalArgumentException(String.format(message, minCars));
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
            validateCarNameSize(carName);
        }
    }

    private static void validateCarName(String carName) {
        message = ErrorMessage.INVALID_CAR_NAME.getMessage();
        if (!CAR_NAME_REGEX.matcher(carName).matches() || carName.contains(" ") || carName.isEmpty()) {
            throw new IllegalArgumentException(message);
        }
    }

    private static void validateCarNameSize(String carName) {
        int maxCarNameSize = GameCondition.MAX_CAR_NAME_SIZE.getValue();
        message = ErrorMessage.INVALID_CAR_NAME_SIZE.getMessage();
        if (carName.length() > maxCarNameSize) {
            throw new IllegalArgumentException(String.format(message, maxCarNameSize));
        }
    }
}
