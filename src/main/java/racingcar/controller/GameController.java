package racingcar.controller;

import racingcar.domain.car.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startGame() {
        String[] carNames = inputView.readCarNames();
        int attemptCount = inputView.readAttemptCount();
    }

    private void printRoundResult(Car car) {
        outputView.printCarNameAndPosition(car.getName(), car.getPosition());
    }
}
