package racingcar.domain;

import java.util.Comparator;
import java.util.List;
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
        int fastestCarPosition = findFastestCar();
        return cars.stream()
                .filter(car -> car.isTopPosition(fastestCarPosition))
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_DELIMITER));
    }

    private int findFastestCar() {
        List<Integer> carRanks = cars.stream()
                .sorted(Comparator.comparing(Car::getPosition).reversed())
                .map(Car::getPosition)
                .collect(Collectors.toList());
        return carRanks.get(0);
    }
}
