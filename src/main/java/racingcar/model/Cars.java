package racingcar.model;

import java.util.Comparator;
import java.util.List;
import racingcar.dto.RoundResult;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void attemptForward() {
        cars.forEach(Car::attemptForward);
    }

    public RoundResult getRoundResult() {
        return new RoundResult(cars.stream()
                .map(Car::getCarState)
                .toList());
    }

    public List<Car> findWinningCars() {
        return cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .stream().toList();
    }
}