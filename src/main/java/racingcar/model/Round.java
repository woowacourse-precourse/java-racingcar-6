package racingcar.model;

public class Round {
    private final int round;

    public Round(int round) {
        validate(round);
        this.round = round;
    }

    private void validate(int round) {
        if (round > Integer.MAX_VALUE || round <= 0) {
            throw new IllegalArgumentException("범위에서 벗어난 수입니다");
        }
    }

    public int getRound() {
        return round;
    }

}
