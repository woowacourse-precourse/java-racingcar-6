package racingcar.domain;

import racingcar.util.RacingRoundValidator;

public class RacingRound {
    private final int round;

    public RacingRound(String input) {
        RacingRoundValidator.validateInputNotEmpty(input);
        RacingRoundValidator.validateIsParsableToInt(input);
        int roundNumber = Integer.parseInt(input);
        RacingRoundValidator.validateInputRange(roundNumber);
        this.round = roundNumber;
    }

    public int getRound() {
        return round;
    }
}
