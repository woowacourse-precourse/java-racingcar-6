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
        cars = inputView.readCarNames();
        outputView.printInputAttemptCountMessage();
        attemptCount = inputView.readAttemptCount();
        process();
    }

    public void process() {
        while(attemptCount.isNotFinish()) {
            cars.forEach(Car::moveForward);
            attemptCount.decreaseCount();
            outputView.printMoveRecords(cars);
        }
    }
}
