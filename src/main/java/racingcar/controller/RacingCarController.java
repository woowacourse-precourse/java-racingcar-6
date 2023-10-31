package racingcar.controller;

import racingcar.domain.*;
import racingcar.utils.CarListGenerator;
import racingcar.vo.RacingRoundCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cars cars = getCarsFromUser();
        RacingRoundCount racingRoundCount = getRoundCountFromUser();
        displayRunRacingWithRounds(cars, racingRoundCount);
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

    private RacingRoundCount getRoundCountFromUser() {
        String racingRoundCountFromUser = requestRacingRoundCountFromUser();
        return new RacingRoundCount(racingRoundCountFromUser);
    }

    private String requestRacingRoundCountFromUser() {
        outputView.displayRequestRaceCount();
        return inputView.requestRacingRoundCountFromUser();
    }

    private void displayRunRacingWithRounds(Cars cars, RacingRoundCount racingRoundCount) {
        outputView.displayExecutionResult();
        runRacingWithRounds(cars, racingRoundCount);
    }

    private void runRacingWithRounds(Cars cars, RacingRoundCount racingRoundCount) {
        Race race = new Race();
        Camera camera = new Camera();
        for (int round = 0; round < racingRoundCount.value(); round++) {
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
