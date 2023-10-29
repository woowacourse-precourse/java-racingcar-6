package racingcar.domain;

import java.util.stream.Collectors;

public class Winners {
    private static final String WINNER_DELIMITER = ", ";
    private Cars cars;

    private Winners(Cars cars) {
        this.cars = cars;
    }

    public static Winners from(Cars cars) {
        return new Winners(cars);
    }

    public String getWinnerName() {
        int fastestCar = cars.findFastestCar();
        return cars.stream()
                .filter(car -> car.isWinner(fastestCar))
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
