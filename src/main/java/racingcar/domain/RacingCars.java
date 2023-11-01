package racingcar.domain;

import java.util.List;
import java.util.regex.Pattern;
import racingcar.enums.ErrorMessage;
import racingcar.enums.GameCondition;
import racingcar.enums.RegexPattern;

public class RacingCars {
    private final List<Car> cars;
    private static final Pattern CAR_NAME_REGEX = Pattern.compile(RegexPattern.CAR_NAME.getPattern());
    private String message = "";

    public RacingCars(final List<String> carNames) {
        validateMinCars(carNames);
        validateCarNames(carNames);
        this.cars = convertStringToCar(carNames);
    }

    public List<Car> getCars() {
        return cars;
    }

    public static int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private List<Car> convertStringToCar(final List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void validateMinCars(List<String> carNames) {
        int minCars = GameCondition.MIN_CARS.getValue();
        message = ErrorMessage.INVALID_MIN_CARS.getMessage();
        if (carNames.size() < minCars) {
            throw new IllegalArgumentException(String.format(message, minCars));
        }
    }

    private void validateCarNames(List<String> carNames) {
        validateDuplicateCarNames(carNames);
        for (String carName : carNames) {
            validateCarName(carName);
            validateCarNameSize(carName);
        }
    }

    private void validateCarName(String carName) {
        message = ErrorMessage.INVALID_CAR_NAME.getMessage();
        if (!CAR_NAME_REGEX.matcher(carName).matches() || carName.contains(" ")) {
            throw new IllegalArgumentException(message);
        }
    }

    private void validateCarNameSize(String carName) {
        int maxCarNameSize = GameCondition.MAX_CAR_NAME_SIZE.getValue();
        message = ErrorMessage.INVALID_CAR_NAME_SIZE.getMessage();
        if (carName.length() > maxCarNameSize) {
            throw new IllegalArgumentException(String.format(message, maxCarNameSize));
        }
    }

    private void validateDuplicateCarNames(List<String> carNames) {
        if(isDuplicateCarNames(carNames)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_CAR_NAMES.getMessage());
        }
    }

    private boolean isDuplicateCarNames(List<String> carNames) {
        return carNames.size() == carNames.stream().distinct().count();
    }
}
