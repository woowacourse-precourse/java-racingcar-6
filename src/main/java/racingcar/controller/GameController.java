package racingcar.controller;

import racingcar.view.InputMessage;

public class GameController {
    InputMessage inputMessage;

    public void readyGame() {
        inputMessage.carName();

        inputMessage.lap();

    }

    public void startGame() {

    }
}
