package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class FindWinnerController {
    private final List<Car> cars;

    public FindWinnerController(final List<Car> cars) {

        this.cars = new ArrayList<>(cars);
    }

    public List<String> getWinners() {
        return findWinner();
    }

    private int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(-1);
    }

    private List<String> findWinner() {
        return cars.stream()
                .filter(car -> getMaxPosition() == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
