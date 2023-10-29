package racingcar.dto;

public class AttemptCount {
    private final int attemptCount;

    public AttemptCount(String input) {
        attemptCount = toInt(input);
    }

    private int toInt(String input) {
        return Integer.parseInt(input);
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
