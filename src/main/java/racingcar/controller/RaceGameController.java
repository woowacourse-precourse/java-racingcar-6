package racingcar.controller;

import racingcar.service.RacingCarService;
import racingcar.service.ScoreBoardService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final RacingCarService racingCarService;
    private final ScoreBoardService scoreBoardService;

    public RaceGameController() {
        racingCarService = new RacingCarService(InputView.inputCarNames());
        scoreBoardService = new ScoreBoardService();
    }

    public void run() {
        int attemptCount = InputView.inputAttemptCount();
        OutputView.beforeRaceMessage();
        startRace(attemptCount);
        OutputView.showScoreBoard(scoreBoardService.getScoreBoard());
        OutputView.showWinners(scoreBoardService.findWinners());
    }

    private void startRace(int attemptCount) {
        for (int round = 1; round <= attemptCount; round++) {
            racingCarService.moveRacingCars();
            scoreBoardService.recordRound(round, racingCarService.convertToScoreDtoList());
        }
    }

}
