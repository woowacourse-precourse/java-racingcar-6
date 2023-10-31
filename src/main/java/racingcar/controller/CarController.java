package racingcar.controller;

import racingcar.domain.Names;
import racingcar.domain.RacingCarGame;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private RacingCarGame racingCarGame;

    public void run() {
        racingCarGame = new RacingCarGame(readNames(), readTryCount());
        startRacing();
        outputView.printWinner(racingCarGame.getWinner());
    }

    private void startRacing() {
        outputView.printResultMessage();
        while (racingCarGame.isProgress()) {
            racingCarGame.race();
            outputView.printRacingResult(racingCarGame.getRacingResult());
        }
    }

    private Names readNames() {
        outputView.printNameMessage();
        return inputView.readNames();
    }

    private TryCount readTryCount() {
        outputView.printTryCountMessage();
        return inputView.readTryCount();
    }
}
