package racingcar.game.domain;

import racingcar.game.validation.RoundValidator;
import racingcar.game.validation.Validator;

public class Round {

    private static final Validator VALIDATOR = new RoundValidator();

    private final int movingCount;

    private Round(int movingCount) {
        this.movingCount = movingCount;
    }

    public static Round create(String stringMovingCount) {
        VALIDATOR.execute(stringMovingCount);

        int movingCount = Integer.parseInt(stringMovingCount);
        return new Round(movingCount);
    }

    public int getMovingCount() {
        return movingCount;
    }
}
