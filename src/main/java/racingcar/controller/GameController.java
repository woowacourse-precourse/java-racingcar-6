package racingcar.controller;

import racingcar.model.Car;
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
            int[] randomNumArray = Car.carRandomNum(cars.length);
        }

        OutputView.printWinners();
    }
}
