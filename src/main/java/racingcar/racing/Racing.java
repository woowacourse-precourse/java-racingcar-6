package racingcar.racing;

import racingcar.RacingCars;
import racingcar.view.OutputView;

public class Racing {
    private final int trialCount;
    private final RacingCars racingCars;

    public Racing(int trialCount, RacingCars racingCars) {
        this.trialCount = trialCount;
        this.racingCars = racingCars;
    }

    public void playRacing() {
        executeRacing();
        OutputView.printWinner(racingCars.getWinner());
    }

    private void executeRacing() {
        for (int i = 0; i < trialCount; i++) {
            racingCars.move();
            OutputView.printRoundResult(racingCars.roundResults());
        }
    }
}
