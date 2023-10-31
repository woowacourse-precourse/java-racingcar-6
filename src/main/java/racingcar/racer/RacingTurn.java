package racingcar.racer;

import racingcar.validator.RacerValidator;

public class RacingTurn {
    private final int count;

    protected RacingTurn(int count) {
        RacerValidator.validateTotalTurnRange(count);

        this.count = count;
    }

    public static RacingTurn from(int totalTurn) {
        return new RacingTurn(totalTurn);
    }

    public int getCount() {
        return count;
    }
}
