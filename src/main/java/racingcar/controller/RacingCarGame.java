package racingcar.controller;

import racingcar.view.InputView;

import static racingcar.util.GameReader.readAttemptCount;
import static racingcar.util.GameReader.readCarNames;

public class RacingCarGame {

    public void play() {
        InputView.printDemandCarNames();
        readCarNames();

        InputView.printDemandAttemptCount();
        readAttemptCount();
    }
}
