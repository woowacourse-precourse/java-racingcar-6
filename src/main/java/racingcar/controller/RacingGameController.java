package racingcar.controller;

import static racingcar.view.InputView.inputAttemptCount;
import static racingcar.view.InputView.inputCarNames;

import racingcar.domain.Race;

public class RacingGameController {

    public void execute() {
        Race race = new Race(inputCarNames(), inputAttemptCount());
        race.startRace();
    }
}
