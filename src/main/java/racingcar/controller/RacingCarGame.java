package racingcar.controller;

import racingcar.view.InputView;

import static racingcar.util.InputUtils.readAttemptCount;
import static racingcar.util.InputUtils.readCarNames;

public class RacingCarGame {

    public void play() {
        InputView.printDemandCarNames();
        readCarNames();

        InputView.printDemandAttemptCount();
        readAttemptCount();
    }
}
