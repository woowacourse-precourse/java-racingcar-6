package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public record CarGarage(List<Car> cars) {

    public Winner findWinner() {
        int maxPosition = getMaxPosition(cars);
        List<Car> winner = cars.stream()
                .filter(it -> it.getPosition() == maxPosition)
                .collect(Collectors.toList());
        return new Winner(winner);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
