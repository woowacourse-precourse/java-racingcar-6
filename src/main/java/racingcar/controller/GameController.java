package racingcar.controller;

import racingcar.view.InputMessage;

public class GameController {
    InputMessage inputMessage;

    public void readyGame() {
        inputMessage.carName();
        inputMessage.times();

    }

    public void startGame() {

    }
}
