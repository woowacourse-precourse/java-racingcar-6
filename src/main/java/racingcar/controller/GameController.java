package racingcar.controller;

import racingcar.common.GameServiceFactory;
import racingcar.domain.dto.WinnersDto;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        this.gameService = GameServiceFactory.createGameService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {
        initializeGame();
        playGame();
    }

    private void initializeGame() {
        String carNames = receiveCarNames();
        String tryCount = receiveGameCount();
        this.gameService.initializeGame(carNames, tryCount);
    }

    private void playGame() {
        printResultMessage();
        playRounds();
        printWinners();
    }

    private void printResultMessage() {
        this.outputView.printResultMessage();
    }

    private void playRounds() {
        while (!this.gameService.isGameFinished()) {
            this.gameService.playRound();
            this.outputView.printCarPositions(this.gameService.getCarPositions());
        }
    }

    private void printWinners() {
        WinnersDto winners = this.gameService.getWinners();
        this.outputView.printWinners(winners);
    }

    private String receiveCarNames() {
        this.outputView.printInputCarNamesMessage();
        return this.inputView.inputCarNames();
    }

    private String receiveGameCount() {
        this.outputView.printInputGameTryCountMessage();
        return this.inputView.inputGameCount();
    }
}
