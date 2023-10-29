package racingcar.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import racingcar.constants.MyEnum;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final OutputView outputView;
    private final InputView inputView;
    private final RacingGameService racingGameService;

    public RacingGame() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
        this.racingGameService = new RacingGameService();
    }

    public void run() {
        handleCarNameInput();
        handleNumberOfAttemptsInput();
        handlePlayRacingGame();
        handleWinners();
    }

    public void handleCarNameInput() {
        outputView.printCarNameInputMessage();
        String carNames = inputView.carNameInput();
        racingGameService.addCars(carNames);
    }

    public void handleNumberOfAttemptsInput() {
        outputView.printNumberOfAttemptsInputMessage();
        String attempts = inputView.numberOfAttempsInput();
        racingGameService.setAttempts(attempts);
    }

    public void handlePlayRacingGame() {
        outputView.printPlayResultMessage();

        while (!racingGameService.reaches()) {
            List<Map<MyEnum, String>> results = racingGameService.getResultList();
            outputView.printPlayResult(results);
        }
    }

    public void handleWinners() {
        racingGameService.addWinners();
        String winnerList = racingGameService.getWinnersNames();
        outputView.printWinners(winnerList);
    }
}
