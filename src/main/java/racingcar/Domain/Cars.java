package racingcar.Domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private int findFastestPosition() {
        int fastestPosition = 0;

        for (Car car : cars) {
            fastestPosition = car.findFasterPosition(fastestPosition);
        }

        return fastestPosition;
    }

    public List<Car> findWinners() {
        int fastestPosition = findFastestPosition();

        return cars.stream()
                .filter(car -> car.isWinnerPosition(fastestPosition))
                .collect(Collectors.toList());
    }
}
