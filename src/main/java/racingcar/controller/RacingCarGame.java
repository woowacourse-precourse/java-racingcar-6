package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarGame {
    private String carNames;
    private int number;

    private CarController carController;

    public void start() {
        carNames = InputView.readCarNames();
        number = InputView.readNumber();

        OutputView.printBlankLine();
        run();
    }

    private void run() {
        carController = new CarController(carNames);

        OutputView.printGameResult();

        for (int i = 0; i < number; i++) {
            carController.move();
            OutputView.printBlankLine();
        }

        exist();
    }

    private void exist() {
        OutputView.printGameWinner(carController.getWinner());
    }
}
