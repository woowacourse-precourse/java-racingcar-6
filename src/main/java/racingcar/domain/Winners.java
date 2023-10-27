package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final String WINNER_DELIMITER = ", ";
    private List<Car> cars;

    private Winners(List<Car> cars) {
        this.cars = cars;
    }

    public static Winners createWinnersFrom(List<Car> cars) {
        return new Winners(cars);
    }

    public String getWinnerName() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
