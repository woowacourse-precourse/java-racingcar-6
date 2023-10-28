package racingcar.controller;

import racingcar.domain.Names;
import racingcar.domain.RacingCarGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private RacingCarGame racingCarGame;

    public void run() {
        racingCarGame = new RacingCarGame(readNames());
        startRacing(readTryCount());
        outputView.printWinner(racingCarGame.getWinner());
    }

    private void startRacing(int count) {
        outputView.printResultMessage();
        while (racingCarGame.isProgress(count)) {
            racingCarGame.race();
            outputView.printRacingResult(racingCarGame.getRacingResult());
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
