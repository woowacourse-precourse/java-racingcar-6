package racingcar.controller;

import racingcar.view.InputView;

public class GameController {
    InputView inputView = new InputView();

    public void startGame() {
        String carName = inputView.enterCarName();
        System.out.println(carName);
    }
}
