package racingcar.domain.winner;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;

public class WinnerChecker {
    private final List<Car> cars;

    public WinnerChecker(List<Car> cars) {
        this.cars = cars;
    }

    public List<String> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalStateException("자동차 목록이 비어 있습니다."));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
