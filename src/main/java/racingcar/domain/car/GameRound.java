package racingcar.domain.car;

import racingcar.domain.car.validator.GameRoundValidator;

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
