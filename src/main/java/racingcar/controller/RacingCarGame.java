package racingcar.controller;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;
import racingcar.view.InputView;

import static racingcar.util.GameReader.readAttemptCount;
import static racingcar.util.GameReader.readCarNames;

public class RacingCarGame {

    public void play() {
        InputView.printDemandCarNames();
        Cars cars = new Cars(readCarNames());

        InputView.printDemandAttemptCount();
        Attempt attempt = new Attempt(readAttemptCount());
    }
}
