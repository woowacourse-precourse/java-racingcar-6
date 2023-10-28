package racingcar.controller;

import racingcar.domain.RacingCars;
import racingcar.view.OutputView;

public class Racing {
    private final int trialCount;
    private final RacingCars racingCars;

    public Racing(int trialCount, RacingCars racingCars) {
        this.trialCount = trialCount;
        this.racingCars = racingCars;
    }

    // 레이싱 시작
    public void startRacing() {
        executeRaces();
        announceWinner();
    }

    // 레이싱 실행
    private void executeRaces() {
        for (int i = 0; i < trialCount; i++) {
            racingCars.moveCars();
            OutputView.printRoundResult(racingCars.getRoundResults());
        }
    }

    // 승자 발표
    private void announceWinner() {
        OutputView.printWinner(racingCars.determineWinnerInfo());
    }
}
