package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;
    private final int maxPosition;

    public Winners(List<Car> cars) {
        maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<String> getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars) {
        int max = Integer.MIN_VALUE;
        for (Car car : cars) {
            if (max < car.getPosition()) {
                max = car.getPosition();
            }
        }

        return max;
    }
}
