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
        run(attemptCount);
    }

    private void run(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            racingCarService.moveRacingCars();
        }
    }

}
