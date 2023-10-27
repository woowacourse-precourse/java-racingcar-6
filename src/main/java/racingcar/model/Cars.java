package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.exception.CarsCountException;

import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> racingCars;

    public Cars(String carNames) {
        this.racingCars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        validateCarsCount();
    }

    private void validateCarsCount() {
        if (racingCars.size() < 2) {
            throw new CarsCountException(ErrorMessage.CARS_COUNT_ERROR.getMessage());
        }
    }


}
