package racingcar.domain.gamemanager.controller;

import racingcar.domain.view.InputView;

public class GameController {

    public void startGame() {
        InputView.printGameStart();
        String carNames = InputView.receiveUserInput();
    }
}
