package racingcar.controller;

import racingcar.model.Input;
import racingcar.view.InputMessage;

import java.util.List;

public class GameController {
    InputMessage inputMessage;
    Input input;
    List<String> car;
    int lap;

    public void readyGame() {
        inputMessage.carName();
        car=input.car();
        inputMessage.lap();
        lap=input.lap();
    }

    public void startGame() {

    }
}
