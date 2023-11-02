package racingcar.domain;

public class Round {
    private final static String ROUND_VALIDATION_REGEX = "^[1-9]\\d{0,2}$";

    private final Integer round;

    public Round(String round) {
        isValidAttemptNumber(round);
        this.round = Integer.parseInt(round);
    }

    private static void isValidAttemptNumber(String attemptNumber) {
        if (!attemptNumber.matches(ROUND_VALIDATION_REGEX)) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getRound() {
        return round;
    }
}
