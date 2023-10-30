package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.ScoreBoardService;
import racingcar.view.InputView;

public class RaceGameController {
    private final RacingCarService racingCarService;
    private final ScoreBoardService scoreBoardService;

    public RaceGameController() {
        racingCarService = new RacingCarService(InputView.inputCarNames());
        scoreBoardService = new ScoreBoardService();
    }

    public void startRace() {
        int attemptCount = InputView.inputAttemptCount();
        run(attemptCount);
    }

    private void run(int attemptCount) {
        for (int round = 1; round <= attemptCount; round++) {
            racingCarService.moveRacingCars();
            scoreBoardService.recordRound(round, racingCarService.getRacingCars());
        }
    }

}
