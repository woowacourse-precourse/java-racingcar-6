package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarForward;
import racingcar.model.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void run() {
        OutputView.printCarName();
        InputView.inputCarNames();

        OutputView.printGameCount();
        int gameCount = InputView.inputGameCount();

        OutputView.printGameResult();
        CarForward.forwardCountInit();

        for (int i = 0; i < gameCount; i++) {
            Car.carRandomNum();

            CarForward.carMoreThanFour();

            OutputView.printForwardResult();
        }

        Winner.compareWinner();

        OutputView.printFinal();

        OutputView.printWinners();
    }
}
