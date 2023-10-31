package racingcar;

public class RacingAttempt {

    private static final int MIN_ATTEMPTS = 5;
    private static final int MAX_ATTEMPTS = 100;

    private final int attempts;

    public RacingAttempt(String attemptsString) {
        int parsedAttempts = parseAttempts(attemptsString);
        validate(parsedAttempts);

        this.attempts = parsedAttempts;
    }

    private int parseAttempts(String attemptsString) {
        try {
            return Integer.parseInt(attemptsString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자로 입력해야 합니다.");
        }
    }

    private void validate(int parsedAttempts) {
        if (parsedAttempts < MIN_ATTEMPTS || MAX_ATTEMPTS < parsedAttempts) {
            throw new IllegalArgumentException(
                    String.format("시도할 회수는 %d 이상이고 %d 이하여야 합니다.", MIN_ATTEMPTS, MAX_ATTEMPTS));
        }
    }

    public int getAttempts() {
        return attempts;
    }
}
