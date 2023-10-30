package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.view.InputView;

public class RaceGameController {
    private final RacingCarService racingCarService;

    public RaceGameController() {
        racingCarService = new RacingCarService(InputView.inputCarNames());
    }

    public void startRace(){
        int attemptCount = InputView.inputAttemptCount();
    }

}
