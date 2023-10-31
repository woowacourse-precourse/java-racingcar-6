package racingcar.game.domain;

import racingcar.game.validation.RoundValidator;
import racingcar.game.validation.Validator;

public class Round {

    private static final Validator VALIDATOR = new RoundValidator();

    private final int movingCount;

    private Round(int movingCount) {
        this.movingCount = movingCount;
    }

    public static Round create(int movingCount) {
        VALIDATOR.execute(movingCount);

        return new Round(movingCount);
    }

    public int getMovingCount() {
        return movingCount;
    }
}
