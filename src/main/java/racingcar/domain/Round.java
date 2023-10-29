package racingcar.domain;

public class Round {
    private static final int MIN_ROUND = 0;
    private final int round;

    private Round(int round) {
        this.round = round;
    }

    public static Round getRound(int round) {
        roundValidation(round);
        return new Round(round);
    }

    private static void roundValidation(int round) {
        if (round < MIN_ROUND) {
            throw new IllegalArgumentException();
        }
    }

    public int getRound() {
        return round;
    }
}
