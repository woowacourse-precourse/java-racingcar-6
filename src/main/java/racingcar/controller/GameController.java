package racingcar.controller;

import racingcar.common.GameServiceFactory;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;


    public GameController() {
        this.gameService = GameServiceFactory.createGameService();
        this.inputView= new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        initializeGame();
        playGame();
    }

    private void initializeGame() {
        String carNames = receiveCarNames();
        String tryCount = receiveGameCount();
        gameService.initializeGame(carNames, tryCount);
    }

    private void playGame() {
        outputView.printResultMessage();
        while (!gameService.isGameFinished()) {
            gameService.playRound();
            outputView.printCarPositions(gameService.getCarPositions());
        }

    }

    private String receiveCarNames() {
        outputView.printInputCarNamesMessage();
        return inputView.inputCarNames();
    }

    private String receiveGameCount() {
        outputView.printInputGameTryCountMessage();
        return inputView.inputGameCount();
    }
}
