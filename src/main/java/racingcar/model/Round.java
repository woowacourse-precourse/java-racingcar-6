package racingcar.model;

public record Round(int round) {

    private static final String WRONG_ROUND = "라운드는 최소 1 이상이어야 합니다.";
    private static final int MIN_ROUND = 1;

    public Round {
        validate(round);
    }

    private void validate(int round) {
        if (round < MIN_ROUND) {
            throw new IllegalArgumentException(WRONG_ROUND);
        }
    }
}
