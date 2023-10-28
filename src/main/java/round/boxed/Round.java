package round.boxed;

import racingcar.exception.InvalidRoundException;

public abstract class Round {
    public static final int MIN_ROUND = 1;

    protected final int round;

    protected Round(final int round) {
        validateRound(round);
        this.round = round;
    }

    private static void validateRound(final int round) {
        if (round < MIN_ROUND) {
            throw new InvalidRoundException();
        }
    }

    public boolean isAfter(final Round other) {
        return round > other.round;
    }

}
