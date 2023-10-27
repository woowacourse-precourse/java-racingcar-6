package racingcar.controller;

import java.util.function.Supplier;
import racingcar.domain.car.Cars;
import racingcar.domain.car.carcomponent.carmove.CarMoveReader;

public class CarController {
    private final Cars cars;
    private final CarMoveReader carMoveReader;

    public CarController(Cars cars, CarMoveReader carMoveReader) {
        this.cars = cars;
        this.carMoveReader = carMoveReader;
    }

    public String moveCarsAndGetResult(Supplier<Boolean> moveOrNot) {
        String result = cars.moveCarAndGetResult(moveOrNot);
        carMoveReader.moveCar();
        return result;
    }

    public boolean isMovable() {
        return carMoveReader.canMoveCar();
    }

    public String getWinner() {
        return cars.getWinner();
    }
}
