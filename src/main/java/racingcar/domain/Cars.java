package racingcar.domain;

import static racingcar.constant.CarRacingConstant.CAR_NAME_SEPARATOR;
import static racingcar.constant.CarRacingErrorMessage.CAR_NAME_BLANK_ERROR_MESSAGE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars fromCarNames(String carNames) {
        validate(carNames);
        List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_SEPARATOR))
                .map(Car::fromName)
                .toList();

        return new Cars(cars);
    }

    private static void validate(String carNames) {
        validateIsEndWithSeparator(carNames);
    }

    private static void validateIsEndWithSeparator(String carNames) {
        if (carNames.endsWith(CAR_NAME_SEPARATOR)) {
            throw new IllegalArgumentException(CAR_NAME_BLANK_ERROR_MESSAGE);
        }
    }


    public List<Car> tryToMove() {
        for (Car car : cars) {
            car.triesToMove();
        }
        return getCurrentStatus();
    }

    public List<Car> getCurrentStatus() {
        return Collections.unmodifiableList(cars);
    }
}
