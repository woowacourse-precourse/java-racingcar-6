package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.view.InputView;

public class RacingGame {

    public static final InputView inputView = new InputView();

    private RacingGame() {
    }

    public static void run() {
        String carNames = inputView.enterCarNames();
        Cars cars = Cars.from(carNames);

    }
}
