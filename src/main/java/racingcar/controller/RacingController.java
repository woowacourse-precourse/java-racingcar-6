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
    private final Judgement judgement;

    public RacingController(InputView inputView, OutputView outputView, Judgement judgement) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.judgement = judgement;
    }

    public void run() {
        String carNamesFromUser = requestCarNamesFromUser();
        List<Car> carLIst = CarListGenerator.generateCarList(carNamesFromUser);
        Cars cars = new Cars(carLIst);

        String racingRoundCountFromUser = requestRacingRoundCountFromUser();
        RoundCount roundCount = new RoundCount(racingRoundCountFromUser);

        outputView.displayExecutionResult();
        runRace(roundCount, cars);
        outputView.displayFinalWinners(judgement.determineWinners(cars));
    }

    private String requestCarNamesFromUser() {
        outputView.displayRequestCarNames();
        return inputView.requestCarNameFromUser();
    }

    private String requestRacingRoundCountFromUser() {
        outputView.displayRequestRaceCount();
        return inputView.requestRacingRoundCountFromUser();
    }

    private void runRace(RoundCount roundCount, Cars cars) {
        Race race = new Race();
        Camera camera = new Camera();
        for (int round = 0; round < roundCount.getValue(); round++) {
            race.runOneRound(cars);
            String racingState = camera.captureRaceState(cars);
            outputView.displayRacingState(racingState);
        }
    }
}
