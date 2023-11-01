package racingcar.domain;

public class Game {
    private static final int MIN_ROUND_COUNT = 1;
    private static final int MAX_ROUND_COUNT = 10;
    private static final String ROUND_COUNT_RANGE_ERROR_MESSAGE = "이동 횟수는 10 이하의 자연수여야 함";

    private final int roundCount;
    private int executedRoundCount;

    private Game(int roundCount) {
        if (!validateRoundCountRange(roundCount)) {
            throw new IllegalArgumentException(ROUND_COUNT_RANGE_ERROR_MESSAGE);
        }
        this.roundCount = roundCount;
        this.executedRoundCount = 0;
    }

    public static Game createNewGame(int roundCount) {
        return new Game(roundCount);
    }

    private boolean validateRoundCountRange(int roundCount) {
        return roundCount >= MIN_ROUND_COUNT && roundCount <= MAX_ROUND_COUNT;
    }

    public void incrementExecutedRoundCount() {
        executedRoundCount++;
    }

    public boolean isGameEnd() {
        return executedRoundCount == roundCount;
    }
}
