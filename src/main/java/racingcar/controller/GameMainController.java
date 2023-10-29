package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameMainController {

    private GameService gameService = new GameService();

    public void startGame() {
        InputView.requestCarName();
        gameService.getCarList();
        InputView.requestGameCount();
        gameService.getGameCount();
    }

    public void playGame() {
        OutputView.printResultMessage();
        gameService.playGame();
    }
}
