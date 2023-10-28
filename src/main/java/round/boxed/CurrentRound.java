package round.boxed;

public final class CurrentRound extends Round {
    public CurrentRound(final int round) {
        super(round);
    }

    public static CurrentRound min() {
        return new CurrentRound(Round.MIN_ROUND);
    }

    public CurrentRound nextRound() {
        return new CurrentRound(super.round + 1);
    }
}
