package racingcar.controller;

import static racingcar.view.InputView.*;

import racingcar.domain.Race;

public class RacingGameController {

    public void execute() {
        Race race = new Race(inputCarNames(), inputAttemptCount());
        race.startRace();
    }
}
