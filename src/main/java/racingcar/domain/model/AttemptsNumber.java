package racingcar.domain.model;

public record AttemptsNumber(int attempts) {

    public AttemptsNumber(String attempts) {
        this(parseInt(attempts));
    }

    public AttemptsNumber {
        validateAttemptsNumber();
    }

    private static int parseInt(String attempts) {
        if (!attempts.matches("\\d+")) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }

        return Integer.parseInt(attempts);
    }

    private void validateAttemptsNumber() {
        if (attempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
