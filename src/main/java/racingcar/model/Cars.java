package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.exception.CarsCountException;
import racingcar.exception.NotFoundCarPositionException;

import java.util.Arrays;
import java.util.List;

public class Cars {
    public static final String DIVISION = ",";
    private final List<Car> racingCars;

    public Cars(String carNames) {
        this.racingCars = Arrays.stream(carNames.split(DIVISION))
                .map(Car::new)
                .toList();
        validateCarsCount();
    }

    private void validateCarsCount() {
        if (racingCars.size() < 2) {
            throw new CarsCountException(ErrorMessage.CARS_COUNT_ERROR.getMessage());
        }
    }

    public String statusCarsPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        racingCars
                .forEach(car -> stringBuilder.append(car.statusCarPosition()));

        return stringBuilder.toString();
    }

    private int findMaxCarPosition() {
        return racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new NotFoundCarPositionException(ErrorMessage.NOT_FOUND_MAX_CAR_POSITION.getMessage()));
    }

    public List<Car> getRacingCars() {
        return racingCars;
    }
}
