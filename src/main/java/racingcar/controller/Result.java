package racingcar.controller;

import racingcar.domain.RacingWinners;
import racingcar.view.OutputView;

public class Result {
    private final RacingWinners racingWinners;

    public Result(RacingWinners racingWinners) {
        this.racingWinners = racingWinners;
    }

    public void announce() {
        OutputView.printWinner(racingWinners.getFinalResult());
    }
}
