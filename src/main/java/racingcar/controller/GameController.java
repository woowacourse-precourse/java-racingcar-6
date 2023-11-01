package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private GameService gameService;

    public void start() {
        gameService = new GameService(readCarNames());
        process(readAttemptCount());
    }

    private void process(int attemptCount) {
        outputView.printProcessResultTitle();
        while (gameService.isNotFinish(attemptCount)) {
            gameService.move();
            outputView.printMoveRecords(gameService.getRecord());
        }
        finish();
    }

    private void finish() {
        outputView.printWinnerName(gameService.getWinners());
    }

    private int readAttemptCount() {
        outputView.printInputAttemptCountMessage();
        return inputView.readAttemptCount();
    }

    private Cars readCarNames() {
        outputView.printInputCarNameMessage();
        return inputView.readCarNames();
    }
}
