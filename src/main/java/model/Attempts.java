package model;

public class Attempts {

    private int attempts;
    private static final String EMPTY_MESSAGE = "공백 혹은 빈 문자열은 입력 할 수 없습니다.";
    private static final String ONLY_NUMBER_INPUT_MESSAGE = "숫자만 입력 가능합니다.";

    public Attempts(String attempts) {
        validateEmpty(attempts);
        validateIsNumericInput(attempts);
        this.attempts = Integer.parseInt(attempts);
    }

    public int getAttempts() {
        return this.attempts;
    }

    private void validateEmpty(String attempts) {
        if (isEmpty(attempts)) {
            throw new IllegalArgumentException(EMPTY_MESSAGE);
        }
    }

    private boolean isEmpty(String attempts) {
        return attempts.isEmpty() || attempts.isBlank();
    }

    private void validateIsNumericInput(String attempts) {
        try {
            Integer.parseInt(attempts);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ONLY_NUMBER_INPUT_MESSAGE);
        }
    }
}
