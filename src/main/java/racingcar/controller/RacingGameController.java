package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarName;
import racingcar.model.RacingNumber;
import racingcar.view.InputView;

public class RacingGameController {
    private final InputView inputView;
    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void setCarName(String names) {
        inputView.inputCarNames();
        // validation
        // save CarName
    }

    public void setAttempts(String attempts) {
        inputView.inputAttempts();
        // validation
        // save attempts
    }

    public void startGame(String names, String attempts) {
        Car car = Car.makeCar(new CarName(names), new RacingNumber());
        car.generateRandomNumber();
        System.out.println(car.toString());
        car.stopOrMove();
        System.out.println(car.toString());
    }
}
