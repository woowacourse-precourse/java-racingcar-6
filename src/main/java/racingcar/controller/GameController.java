package racingcar.controller;

import racingcar.domain.AttemptCount;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private List<Car> cars;
    private AttemptCount attemptCount;

    public void start() {
        outputView.printInputCarNameMessage();
        List<Car> cars = inputView.readCarNames();
        outputView.printInputAttemptCountMessage();
        AttemptCount attemptCount = inputView.readAttemptCount();
        process(cars, attemptCount);
    }

    private void process(List<Car> cars, AttemptCount attemptCount) {
        outputView.printProcessResultTitle();
        while(attemptCount.isNotFinish()) {
            cars.forEach(Car::moveForward);
            attemptCount.decreaseCount();
            outputView.printMoveRecords(cars);
        }
    }
    }
}
