package racingcar.controller;

import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private RacingCarGame racingCarGame;

    public void start() {
        racingCarGame = new RacingCarGame(readNames());
        racingCarGame.race(readTryCount());
    }

    private List<String> readNames() {
        outputView.printNameMessage();
        return inputView.readNames();
    }

    private int readTryCount() {
        outputView.printTryCountMessage();
        return inputView.readTryCount();
    }
}
