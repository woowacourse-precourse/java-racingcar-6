package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveRule;

import java.util.List;

public class CarService {
    private final Cars cars;
    private final MoveRule moveRule;

    public CarService(Cars cars, MoveRule moveRule) {
        this.cars = cars;
        this.moveRule = moveRule;
    }

    public void moveAllCarByRandom() {
        cars.getCars().forEach(car -> car.move(moveRule));
    }

    public List<String> findWinnersName() {
        List<Car> winningCars = cars.getWinningCars().getCars();
        return winningCars.stream().map(Car::getName).toList();
    }
}
