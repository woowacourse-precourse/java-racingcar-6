package racingcarv2.model;

import racingcarv2.exception.ErrorException;

public class RoundTotal {
    private final int roundTotalValue;

    public RoundTotal(int roundTotal) {
        validateNumberRange(roundTotal);
        this.roundTotalValue = roundTotal;
    }

    private void validateNumberRange(int roundTotal) {
        if (roundTotal > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ErrorException.OVER_MAX_INTEGER.getDescription());
        }
    }

    public int getRoundTotalValue() {
        return roundTotalValue;
    }
}
