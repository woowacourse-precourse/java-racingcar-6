package racingcar.controller;

import java.util.List;
import java.util.Map;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService racingGameService;

    private boolean isGoal = false;

    public RacingGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.racingGameService = new RacingGameService();
    }

    public void run() {
        handleCarNameInput();
        handleNumberOfattempsInput();
        handlePlayRacingGame();
        handleWinners();
    }

    public void handleCarNameInput() {
        outputView.printCarNameInputMessage();
        String carNames = inputView.carNameInput();
        racingGameService.addCars(carNames);
    }

    public void handleNumberOfattempsInput() {
        outputView.printNumberOfattempsInputMessage();
        String attemps = inputView.numberOfAttempsInput();
        racingGameService.setAttemps(attemps);
    }

    public void handlePlayRacingGame() {
        while (!isGoal) {
            List<Map<String, String>> results = racingGameService.getResultList();
            outputView.printPlayResult(results);
            isGoal = racingGameService.reaches();
        }
    }

    public void handleWinners() {
        String winnerList = racingGameService.getWinners();
        outputView.printWinners(winnerList);
    }
}
