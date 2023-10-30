package racingcar.controller;

import racingcar.model.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {
    public void start() {
        OutputView.printStartMessage();
        String racingCarsString = InputView.getRacingCars();

        OutputView.printTryMessage();
        String tryNumberString = InputView.getTryNumber();

        OutputView.printShowResultString();
        RandomNumber.makeRandomNumber();

    }
}