package racingcar.domain.round;

import racingcar.domain.round.validator.GameRoundValidator;

public class GameRound {

    private int count;

    private static final int ZERO_NUMBER = 0;

    public GameRound(final int count) {
        GameRoundValidator.validateGameRoundCount(count);
        this.count = count;
    }

    public boolean isContinuable() {
        return this.count != ZERO_NUMBER;
    }

    public void isCountDecrease() {
        this.count--;
    }

    public int getCount() {
        return this.count;
    }
}
