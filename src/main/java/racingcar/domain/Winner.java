package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<Car> cars = new ArrayList<>();

    public Winner(List<Car> cars) {
        this.cars = getWinners(cars);
    }

    public List<Car> getCars() {
        return cars;
    }

    private List<Car> getWinners(List<Car> cars) {
        int maxMoveCount = getMaxMoveCount(cars);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .collect(Collectors.toList());
    }

    private int getMaxMoveCount(List<Car> cars) {
        return cars.stream()
                .map(Car::getMoveCount)
                .max(Integer::compare)
                .orElse(0);
    }
}
