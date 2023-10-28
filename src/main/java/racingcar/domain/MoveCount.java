package racingcar.domain;

import racingcar.util.ErrorMessage;

public class MoveCount {

    private final int value;

    public MoveCount(String value) {
        validateNumber(value);
        validateRange(value);
        this.value = Integer.parseInt(value);
    }

    private void validateNumber(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
        }

        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
            }
        }
    }

    private void validateRange(String value) {
        int moveCount = Integer.parseInt(value);
        if (moveCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TOO_LOW.getMessage());
        }
    }

    public int get() {
        return this.value;
    }
}
