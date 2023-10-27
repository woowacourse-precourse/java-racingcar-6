package racingcar.domain.gamemanager.controller;

import racingcar.domain.gamemanager.service.GameService;
import racingcar.domain.view.InputView;
import racingcar.domain.view.OutputView;

public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        InputView.printGameStart();
        String carNames = InputView.receiveUserInput();
        gameService.saveCars(carNames);
    }

    public void receiveTryCount() {
        InputView.printTryCount();
        String userInput = InputView.receiveUserInput();
        gameService.startGame(Integer.parseInt(userInput));
    }

    public void endGame() {
        OutputView.printEndGame();
        gameService.getWinner();
    }
}
