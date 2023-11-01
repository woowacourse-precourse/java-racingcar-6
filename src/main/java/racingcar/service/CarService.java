package racingcar.service;

import java.util.function.Supplier;
import racingcar.domain.car.Cars;
import racingcar.domain.car.carmove.CarMoveReader;

public class CarService {
    private final Cars cars;
    private final CarMoveReader carMoveReader;

    public CarService(Cars cars, CarMoveReader carMoveReader) {
        this.cars = cars;
        this.carMoveReader = carMoveReader;
    }

    public String moveCarsAndGetResult(Supplier<Boolean> moveOrNot) {
        String result = cars.moveCarAndGetResult(moveOrNot);
        carMoveReader.raiseMoveCount();
        return result;
    }

    public boolean isMovable() {
        return carMoveReader.canMoveCar();
    }

    public String getWinner() {
        return cars.getWinner();
    }
}
