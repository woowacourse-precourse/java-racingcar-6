package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarForward;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void run() {
        OutputView.printCarName();
        String[] cars = InputView.inputCarNames();

        OutputView.printGameCount();
        int gameCount = InputView.inputGameCount();

        OutputView.printGameResult();

        for (int i = 0; i < gameCount; i++) {
            Car.carRandomNum();
            CarForward.forwardCountInit();
            CarForward.carMoreThanFour();


        }

        OutputView.printWinners();
    }
}
