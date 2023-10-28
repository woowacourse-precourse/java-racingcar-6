package racingcar.controller;

import racingcar.model.Car;
import racingcar.util.car.CarHandler;

public class CarController {
    private final Car car;
    private final CarHandler carHandler;
    public CarController(Car car, CarHandler carHandler) {
        this.car = car;
        this.carHandler = carHandler;
    }
    public String getCarName() {
        return car.getName();
    }
    public int getCarPosition() {
        return car.getPosition();
    }

    public void moveCar(int randomValue) {
        carHandler.go(randomValue);
    }
}
