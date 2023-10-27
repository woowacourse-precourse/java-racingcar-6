package round.boxed;

import racingcar.exception.InvalidMaxRoundException;

public record MaxRound(int maxRound) {

    public static final int MIN_MAX_ROUND = 1;

    public MaxRound {
        validateMaxRound(maxRound);
    }


    public static void validateMaxRound(final int maxRound) {
        if (maxRound < MIN_MAX_ROUND) {
            throw new InvalidMaxRoundException();
        }
    }
}
