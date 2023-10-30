package racingcar.controller;

import racingcar.model.CarGame;
import racingcar.view.InputView;

public class GameController {

    private final InputView inputView = new InputView();
    private final CarGame car = new CarGame();

    public void play() {
        car.setCarsName(inputView.carName());
        car.setPlayCount(inputView.playCount());
    }
}
