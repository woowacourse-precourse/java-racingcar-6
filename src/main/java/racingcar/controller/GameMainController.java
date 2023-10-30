package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameMainController {

    private GameService gameService = new GameService();

    public void run() {
        startGame();
        playGame();
        stopGame();
    }

    private void startGame() {
        InputView.requestCarName();
        gameService.getCarList();
        InputView.requestGameCount();
        gameService.getGameCount();
    }

    private void playGame() {
        OutputView.printResultMessage();
        gameService.playGame();
    }

    private void stopGame() {
        OutputView.printWinnerMessage();
    }
}
