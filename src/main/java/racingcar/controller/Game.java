package racingcar.controller;

import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        InputView.getRacingCars();

        OutputView.printTryMessage();
        InputView.getTryNumber();

        OutputView.printShowResultString();
        RandomNumber.makeRandomNumber();
    }
}