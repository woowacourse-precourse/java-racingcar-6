package racingcar.domain.round;

import racingcar.domain.round.validator.GameRoundValidator;

public class GameRound {

    private int count;

    public GameRound(final int count) {
        GameRoundValidator.validateGameRoundCount(count);
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }
}
