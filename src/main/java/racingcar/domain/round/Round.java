package racingcar.domain.round;

public class Round {
    private int current;
    private final int total;

    public Round(int totalRound) {
        total = totalRound;
        current = 0;
    }

    public void proceedToNextRound() {
        if (hasReachedFinalRound()) {
            throw new IllegalArgumentException("No more rounds left.");
        }
        current++;
    }

    public boolean hasReachedFinalRound() {
        return current >= total;
    }
}
