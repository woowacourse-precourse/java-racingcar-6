package racingcar.domain.round;

public class Round {

    private static final String NEGATIVE_ROUND_EXCEPTION_MESSAGE = "라운드 횟수는 양수만을 허용합니다.";

    private final int rounds;

    private int currentRound = 1;

    public Round(int rounds) {
        validateIsPositive(rounds);
        this.rounds = rounds;
    }

    private void validateIsPositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NEGATIVE_ROUND_EXCEPTION_MESSAGE);
        }
    }

    public void nextRound() {
        currentRound = currentRound + 1;
    }

    public boolean hasMoreRounds() {
        return rounds >= currentRound;
    }

}