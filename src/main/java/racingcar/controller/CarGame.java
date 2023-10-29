package racingcar.controller;

import racingcar.view.InputView;

public class CarGame {
    private InputView inputView;

    public CarGame() {
        inputView = new InputView();
    }

    private void start() {
        String inputName = inputView.inputCarName();
    }
}
