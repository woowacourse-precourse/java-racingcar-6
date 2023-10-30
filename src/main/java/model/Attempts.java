package model;

public class Attempts {

    private int attempts;
    private static final String EMPTY_MESSAGE = "공백 혹은 빈 문자열은 입력 할 수 없습니다.";

    public Attempts(String attempts) {
        validateEmpty(attempts);
        this.attempts = 1;
    }

    private void validateEmpty(String attempts) {
        if (isEmpty(attempts)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    private boolean isEmpty(String attempts) {
        return attempts.isEmpty() || attempts.isBlank();
    }
}
