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
        OutputView.displayRaceResultMessage();
        runRace(attemptCount);
        OutputView.displayScoreBoard(scoreBoardService.getScoreBoard());
        OutputView.displayWinners(scoreBoardService.findFinalRoundWinners());
    }

    private void runRace(int attemptCount) {
        for (int round = 1; round <= attemptCount; round++) {
            racingCarService.moveRacingCars();
            scoreBoardService.recordRound(round, racingCarService.convertToScoreDtoList());
        }
    }

}
