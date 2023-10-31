package racingcar.service;

import racingcar.domain.Cars;
import racingcar.domain.MoveRule;

public class CarService {
    private final Cars cars;
    private final MoveRule moveRule;

    public CarService(Cars cars, MoveRule moveRule) {
        this.cars = cars;
        this.moveRule = moveRule;
    }

    public void moveAllCarByRandom() {
        cars.cars().forEach(car -> car.move(moveRule));
    }

    public Cars findWinners() {
        return cars.getWinningCars();
    }
}
