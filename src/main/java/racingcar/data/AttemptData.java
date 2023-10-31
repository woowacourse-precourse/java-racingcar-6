package racingcar.data;

public class AttemptData {
    private final GameAttempts gameAttempts;
    private final AttemptIndex attemptIndex;
    private static final String NOT_A_POSITIVE_INTEGER = "attemptNumber should be a positive integer.";

    public AttemptData(int attemptNumber) {
        validateAttemptNumber(attemptNumber);
        this.gameAttempts = new GameAttempts(attemptNumber);
        this.attemptIndex = new AttemptIndex();
    }

    public void pickNewNumber(int pickTotal) {
        gameAttempts.createAttempt(pickTotal);
        gameAttempts.pickNewNumberByIndex(attemptIndex.toInt());
    }

    public static void validateAttemptNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NOT_A_POSITIVE_INTEGER);
        }
    }
}
