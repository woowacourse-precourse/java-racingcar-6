package racingcar.controller;

import racingcar.service.RaceService;
import racingcar.view.InputView;

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
    }

    private void printResults() {
    }
}
