package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Cars;
import racingcar.model.RaceResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    private final InputView inputView;
    private final OutputView outputView;

    public RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void startRace() {
        Cars cars = initializeCars();
        int attemptCount = initializeAttemptCount();

        outputView.printGameStartMessage();

        List<RaceResult> raceResults = startRacingRounds(cars, attemptCount);
        displayRaceResults(raceResults);
    }

    private Cars initializeCars() {
        List<String> carNames = inputView.inputCarNames();
        return Cars.fromNames(carNames);
    }

    private int initializeAttemptCount() {
        return inputView.inputAttemptCount();
    }

    private List<RaceResult> startRacingRounds(Cars cars, int attemptCount) {
        List<RaceResult> raceResults = new ArrayList<>();
        for (int i = 0; i < attemptCount; i++) {
            cars = cars.playRound();
            raceResults.add(new RaceResult(cars.toList()));
        }
        return raceResults;
    }

    private void displayRaceResults(List<RaceResult> raceResults) {
        for (RaceResult result : raceResults) {
            outputView.printRaceRoundResult(result.carsToList());
        }
        outputView.printWinner(raceResults.get(raceResults.size() - 1));
    }

}
