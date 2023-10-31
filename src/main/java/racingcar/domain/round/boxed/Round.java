package racingcar.domain.round.boxed;

import racingcar.exception.round.InvalidRoundException;

public abstract class Round {
    public static final int MIN_ROUND = 1;

    protected final int value;

    protected Round(final int value) {
        // validateRound(value);
        this.value = value;
    }

    private static void validateRound(final int round) {
        if (round < MIN_ROUND) {
            throw new InvalidRoundException();
        }
    }

    public boolean isAfter(final Round other) {
        return value > other.value;
    }

}
