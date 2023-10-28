package racingcar.domain.car.controller;

import racingcar.domain.car.service.GameService;
import racingcar.domain.car.view.InputView;
import racingcar.domain.car.view.OutputView;

import java.util.List;

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
        System.out.println();
        gameService.startGame(Integer.parseInt(userInput));
    }

    public void endGame() {
        OutputView.printEndGame();
        List<String> winners = gameService.getWinner();
        String result = String.join(", ", winners);
        System.out.print(result);
    }
}
