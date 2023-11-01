package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.InputNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    public void startGame() {
        Cars cars = new Cars(InputView.inputNames());
        InputNumber inputNumber = new InputNumber(InputView.inputNumber());
        race(cars, inputNumber);
        endGame(cars);
    }

    private void race(Cars cars, InputNumber number) {
        int racingCount = 0;
        OutputView.printExecutionResult();
        while (!number.isEquals(racingCount)) {
            cars.racing();
            OutputView.printCarsPosition(cars.getCars());
            racingCount++;
        }
    }

    private void endGame(Cars cars) {
        OutputView.printCarsPosition(cars.getCars());
        OutputView.printWinners(cars.getWinners());
    }
}
