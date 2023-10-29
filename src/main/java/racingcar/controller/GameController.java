package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class GameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void start() {
        outputView.printInputCarNameMessage();
        List<Car> cars = inputView.readCarNames();
        outputView.printInputAttemptCountMessage();
    }
}
