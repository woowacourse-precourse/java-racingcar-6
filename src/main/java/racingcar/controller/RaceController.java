package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.RaceService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final RaceService raceService;

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
        OutputView.printRaceStartMessage();
        while (!raceService.isRaceFinished()) {
            raceService.runRound();
            List<Car> roundResult = raceService.getRoundResult();
            OutputView.printRoundResult(roundResult);
        }
    }

    private void printResults() {
        List<String> winners = raceService.getWinners();
        OutputView.printWinners(winners);
    }
}
