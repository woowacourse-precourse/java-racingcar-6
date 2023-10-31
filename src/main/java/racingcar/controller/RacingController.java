package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Judgment;
import racingcar.domain.Name;
import racingcar.domain.RepeatCount;
import racingcar.utils.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        Cars cars = setUpRaceCars();
        RepeatCount repeatCount = setUpRaceCount();
        Judgment judgment = setUpJudgment(cars);

        startRace(repeatCount, judgment);
        doneRace(judgment);
    }

    private Cars setUpRaceCars() {
        String names = InputView.inputCarNames();
        return new Cars(names);
    }

    private RepeatCount setUpRaceCount() {
        int repeatCount = InputView.inputRepeatCount();
        return new RepeatCount(repeatCount);
    }

    private Judgment setUpJudgment(Cars cars) {
        return new Judgment(cars, new RandomNumberGenerator());
    }

    private void startRace(RepeatCount repeatCount, Judgment judgment) {
        OutputView.printRacingResult();
        while (repeatCount.isRunable()) {
            race(judgment);
            repeatCount.disCount();
        }
    }

    private void race(Judgment judgment) {
        List<Car> cars = judgment.judge();
        OutputView.printRacingStatus(cars);
    }

    private void doneRace(Judgment judgment) {
        List<Name> winnerNames = judgment.award();
        OutputView.printRacingWinners(winnerNames);
    }
}
