package racingcar.domain;

import racingcar.utils.Validator;

public class Round {

    private final int maxRound;
    private int currentRound = 0;

    public Round(int maxRound) {
        Validator.validate(maxRound);
        this.maxRound = maxRound;
    }

    private void nextRound() {
        this.currentRound++;
    }

    public boolean isMaxRound() {
        if (currentRound == maxRound) {
            return true;
        }
        nextRound();
        return false;
    }
}
