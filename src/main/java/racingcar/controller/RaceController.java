package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private RaceService raceService;

    public RaceController() {
        this.raceService = new RaceService();
    }

    public void start() {
        initializeRace();
        executeRace();
        printResults();
    }

    private void initializeRace() {
        String carNames = InputView.getCarNames();
        int rounds = InputView.getRounds();

        raceService.initializeRace(carNames, rounds);
    }

    private void executeRace() {
        while (!raceService.isRaceFinished()) {
            raceService.runRound();
            // print 라운드 결과
        }
    }

    private void printResults() {
    }
}
