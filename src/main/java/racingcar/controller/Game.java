package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        InputView.getRacingCars();
    }
}