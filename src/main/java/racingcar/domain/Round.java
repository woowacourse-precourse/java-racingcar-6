package racingcar.domain;

public class Round {
    private static final int LAST_ROUND = 0;

    private int round;

    private Round(final int round) {
        validate(round);
        this.round = round;
    }

    public static Round from(final int round) {
        return new Round(round);
    }

    private void validate(final int round) {
        if (round <= LAST_ROUND) {
            throw new IllegalArgumentException("이동 횟수가 0보다 작거나 같습니다.");
        }
    }

    public boolean canPlay() {
        return this.round != LAST_ROUND;
    }

    public void nextRound() {
        if (this.round <= LAST_ROUND) {
            throw new IllegalStateException("이동 횟수는 0보다 커야 합니다.");
        }
        this.round--;
    }

    public int getRound() {
        return round;
    }
}
