package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private Cars cars;

    public void run() {
        cars = new Cars(readNames());
        startRacing(readTryCount());
        outputView.printWinner(cars.getWinner());
    }

    private void startRacing(int tryCount) {
        outputView.printResultMessage();
        for (int i = 0; i < tryCount; i++) {
            cars.race();
            outputView.printRacingResult(cars);
        }
    }

    private Names readNames() {
        outputView.printNameMessage();
        return inputView.readNames();
    }

    private int readTryCount() {
        outputView.printTryCountMessage();
        return inputView.readTryCount();
    }
}
