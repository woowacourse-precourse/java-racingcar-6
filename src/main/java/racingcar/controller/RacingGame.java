package racingcar.controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import racingcar.constants.MyEnum;
import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {
    private final RacingGameService racingGameService;
    private final OutputView outputView;
    private final InputView inputView;

    public RacingGame() {
        this.racingGameService = new RacingGameService();
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        collectCarNames();
        collectNumberOfAttempts();
        playRacingGame();
        announceWinners();
    }

    public void collectCarNames() {
        outputView.printCarNameInputMessage();
        String carNames = inputView.carNamesInput();
        racingGameService.addCars(carNames);
    }

    public void collectNumberOfAttempts() {
        outputView.printNumberOfAttemptsInputMessage();
        racingGameService.setAttempts(inputView.numberOfAttemptsInput());
    }

    public void playRacingGame() {
        outputView.printPlayResultMessage();

        while (!racingGameService.reaches()) {
            racingGameService.everyCarMoveForward();

            List<Map<MyEnum, String>> results = racingGameService.getResultList();
            outputView.printPlayResult(results);
        }
    }

    public void announceWinners() {
        racingGameService.addWinners();
        outputView.printWinners(racingGameService.getWinnersNames());
    }
}
