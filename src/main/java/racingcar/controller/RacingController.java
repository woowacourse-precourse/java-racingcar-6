package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarParser;
import racingcar.domain.Cars;
import racingcar.domain.Judgement;
import racingcar.domain.Race;
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
        List<Car> carLIst = CarParser.generateCarList(carNamesFromUser);
        Cars cars = new Cars(carLIst);
        Race race = new Race(cars);

        String racingRoundCountFromUser = requestRacingRoundCountFromUser();
        RoundCount roundCount = new RoundCount(racingRoundCountFromUser);

        outputView.displayExecutionResult();
        runRace(roundCount, race);
        outputView.displayFinalWinners(judgement.determineWinners(race));
    }

    private String requestCarNamesFromUser() {
        outputView.displayRequestCarNames();
        return inputView.requestCarNameFromUser();
    }

    private String requestRacingRoundCountFromUser() {
        outputView.displayRequestRaceCount();
        return inputView.requestRacingRoundCountFromUser();
    }

    private void runRace(RoundCount roundCount, Race race) {
        for (int round = 0; round < roundCount.getCount(); round++) {
            race.runOneRound();
            String racingState = race.displayRaceState();
            outputView.displayRacingState(racingState);
        }
    }
}
