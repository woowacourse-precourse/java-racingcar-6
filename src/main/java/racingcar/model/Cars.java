package racingcar.model;

import racingcar.constants.ErrorMessage;
import racingcar.constants.GameResultElement;
import racingcar.constants.RacingCarRole;
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
        if (racingCars.size() < RacingCarRole.MIN_CARS_COUNT.getValue()) {
            throw new CarsCountException(ErrorMessage.CARS_COUNT_ERROR.getMessage());
        }
    }

    public String statusCarsPosition() {
        StringBuilder stringBuilder = new StringBuilder();

        racingCars
                .forEach(car -> stringBuilder.append(car.statusCarPosition()));

        return stringBuilder.toString();
    }

    public String getFinalWinners() {
        List<String> winners = racingCars.stream()
                .filter(car -> car.getPosition() == findMaxCarPosition())
                .map(Car::getName)
                .toList();
        return String.join(GameResultElement.COMMA.getElement(), winners);
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
