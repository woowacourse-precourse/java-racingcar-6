package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.GameView;

public class RaceController {
    private final GameView gameView;
    private final RaceService raceService;

    public RaceController() {
        this.gameView = new GameView();
        this.raceService = new RaceService();
    }

    public void raceStart() {
        String carNames = printAndInputCarName();
        String attemptCount = printAndInputAttemptCount();
        advanceRace(carNames, attemptCount);
        printWinners();
    }

    private String printAndInputCarName() {
        gameView.printCarNamesMessage();
        String carNames = gameView.inputCarNames();
        return carNames;
    }

    private String printAndInputAttemptCount() {
        gameView.printAttemptCountMessage();
        String attemptCount = gameView.inputAttemptCount();
        System.out.println();
        return attemptCount;
    }

    private void advanceRace(String carNames, String attemptCount) {
        gameView.printRaceResult();
        raceService.initializeRace(attemptCount, carNames);
        raceService.advanceRace(attemptCount);
    }

    private void printWinners() {
        String winners = raceService.selectWinners();
        gameView.printFinalWinners(winners);
    }
}
