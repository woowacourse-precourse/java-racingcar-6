package model;

import controller.dto.MoveResult;
import controller.dto.Winner;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    private Cars(final List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(final List<String> values) {
        List<Car> cars = values.stream()
            .map(Car::from)
            .toList();

        return new Cars(cars);
    }

    public void actEachCar(final Consumer<Car> action) {
        cars.forEach(action);
    }

    public List<MoveResult> getMoveResult() {
        return cars.stream()
            .map(MoveResult::from)
            .collect(Collectors.toList());
    }

    public List<Car> findWinners() {
        Car winnerCar = cars.stream()
            .max(Comparator.comparing(Car::getMoveCountValue))
            .orElseThrow(NoSuchElementException::new);

        return findOtherWinners(winnerCar.getMoveCountValue());
    }

    private List<Car> findOtherWinners(final int moveCount) {
        return cars.stream()
            .filter(car -> car.hasSameMoveCount(moveCount))
            .collect(Collectors.toList());
    }

    public List<Winner> getWinners() {
        List<Car> winners = findWinners();
        return winners.stream()
            .map(Winner::from)
            .collect(Collectors.toList());
    }
}
