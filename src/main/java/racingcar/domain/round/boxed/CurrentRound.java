package racingcar.domain.round.boxed;

public final class CurrentRound extends Round {
    public CurrentRound(final int value) {
        super(value);
    }

    public static CurrentRound min() {
        return new CurrentRound(Round.MIN_ROUND);
    }

    public CurrentRound nextRound() {
        return new CurrentRound(super.value + 1);
    }
}
