package racingcar.controller;

import static racingcar.model.CriteriaValues.LOWER_BOUND;
import static racingcar.model.CriteriaValues.UPPER_BOUND;

import racingcar.model.RacingCars;
import racingcar.view.RaceView;

public class RaceController {
    private final RaceView raceView = new RaceView();
    private final RacingCars racingCars = new RacingCars();

    public void startGame() {
        addRacingCars();
        startRaceRounds();
        printRaceWinners();
    }

    private void addRacingCars() {
        String carNames = raceView.inputNames();
        racingCars.addCars(carNames);
    }

    private void startRaceRounds() {
        int raceRound = raceView.inputRaceRound();
        raceView.outputRacingResults();
        for (int i = 0; i < raceRound; i++) {
            racingCars.moveCars(LOWER_BOUND.value, UPPER_BOUND.value);
            printRoundStatus();
        }
    }

    private void printRoundStatus() {
        String status = racingCars.getCarsStatus();
        raceView.outputRacingStatus(status);
    }

    private void printRaceWinners() {
        String winners = racingCars.findRaceWinners();
        raceView.outputRaceWinner(winners);
    }

}
