package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

public class RacingCarController {
    InputView inputView = new InputView();
    Car car = new Car();

    public void run() {
        car.inputCars(inputView.carName());
        System.out.println(car.getMovingCars());
        System.out.println(inputView.playNumber());
    }
}
