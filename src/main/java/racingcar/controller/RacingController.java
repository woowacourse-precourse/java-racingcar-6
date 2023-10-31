package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Judgment;
import racingcar.domain.RaceCount;
import racingcar.domain.WinnerNames;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        Cars cars = setUpRaceCars();
        RaceCount raceCount = setUpRaceCount();
        Judgment judgment = setUpJudgment(cars);

        startRace(raceCount, judgment);
        doneRace(judgment);
    }

    private Cars setUpRaceCars() {
        String names = InputView.inputCarNames();
        return new Cars(names);
    }

    private RaceCount setUpRaceCount() {
        int repeatCount = InputView.inputRepeatCount();
        return new RaceCount(repeatCount);
    }

    private Judgment setUpJudgment(Cars cars) {
        return new Judgment(cars, new RandomNumberGenerator());
    }

    private void startRace(RaceCount raceCount, Judgment judgment) {
        OutputView.printRacingResult();
        while (raceCount.isRunable()) {
            race(judgment);
            raceCount.disCount();
        }
    }

    private void race(Judgment judgment) {
        Cars cars = judgment.judge();
        OutputView.printRacingStatus(cars);
    }

    private void doneRace(Judgment judgment) {
        WinnerNames winnerNames = judgment.award();
        OutputView.printRacingWinners(winnerNames);
    }
}
