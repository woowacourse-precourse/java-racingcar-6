package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.List;

public class RaceChecker {
    public RaceResult checkWinner(List<Car> cars) {
        int maxPosition = getMaxPosition(cars);
        List<Car> winners = getCarsWithPosition(cars, maxPosition);

        return new RaceResult(winners);
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> getCarsWithPosition(List<Car> cars, int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }
}
