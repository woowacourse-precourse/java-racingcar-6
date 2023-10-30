package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final Car car = new Car();

    public void play() {
        car.setCarName(inputView.carName());

        int count = inputView.playCount();
    }
}
