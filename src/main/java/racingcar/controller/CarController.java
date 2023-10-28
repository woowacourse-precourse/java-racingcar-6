package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Names;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private Cars cars;
    private final TryCount tryCount = new TryCount();

    public void run() {
        cars = new Cars(readNames());
        startRacing(readTryCount());
        outputView.printWinner(cars.getWinner());
    }

    private void startRacing(int count) {
        outputView.printResultMessage();
        while (tryCount.isProgress(count)) {
            cars.race();
            outputView.printRacingResult(cars);
            tryCount.increaseCount();
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
