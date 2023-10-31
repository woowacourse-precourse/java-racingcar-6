package racingcar.domain;

public class Round {
    private final int round;

    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round < 1) {
            throw new IllegalArgumentException("횟수는 0보다 커야 합니다.");
        }
    }

    public int getRound() {
        return round;
    }
}
