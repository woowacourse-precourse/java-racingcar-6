package racingcar.controller;

import racingcar.domain.*;
import racingcar.util.CarListGenerator;
import racingcar.vo.RoundCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCarsFromUser();
        RoundCount roundCount = getRoundCountFromUser();
        displayRunRacingWithRounds(cars, roundCount);
        displayFinalWinners(cars);
    }

    private Cars getCarsFromUser() {
        String carNamesFromUser = requestCarNamesFromUser();
        List<Car> carLIst = CarListGenerator.generateCarList(carNamesFromUser);
        return new Cars(carLIst);
    }

    private String requestCarNamesFromUser() {
        outputView.displayRequestCarNames();
        return inputView.requestCarNameFromUser();
    }

    private RoundCount getRoundCountFromUser() {
        String racingRoundCountFromUser = requestRacingRoundCountFromUser();
        return new RoundCount(racingRoundCountFromUser);
    }

    private String requestRacingRoundCountFromUser() {
        outputView.displayRequestRaceCount();
        return inputView.requestRacingRoundCountFromUser();
    }

    private void displayRunRacingWithRounds(Cars cars, RoundCount roundCount) {
        outputView.displayExecutionResult();
        runRacingWithRounds(cars, roundCount);
    }

    private void runRacingWithRounds(Cars cars, RoundCount roundCount) {
        Race race = new Race();
        Camera camera = new Camera();
        for (int round = 0; round < roundCount.getValue(); round++) {
            race.runOneRound(cars);
            String racingState = camera.captureRaceState(cars);
            outputView.displayRacingState(racingState);
        }
    }

    private void displayFinalWinners(Cars cars) {
        Judgement judgement = new Judgement();
        String finalWinners = judgement.determineWinners(cars);
        outputView.displayFinalWinners(finalWinners);
    }
}
