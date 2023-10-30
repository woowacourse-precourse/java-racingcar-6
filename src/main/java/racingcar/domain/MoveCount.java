package racingcar.domain;

import racingcar.util.ErrorMessage;

public class MoveCount {

    private final int value;

    private MoveCount(int value) {
        this.value = value;
    }

    public static MoveCount valueOf(String value) {
        validateNumber(value);
        validateRange(value);
        return new MoveCount(Integer.parseInt(value));
    }

    private static void validateNumber(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
        }

        for (char c : value.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NUMBER.getMessage());
            }
        }
    }

    private static void validateRange(String value) {
        int moveCount = Integer.parseInt(value);
        if (moveCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TOO_LOW.getMessage());
        }
    }

    public int intValue() {
        return this.value;
    }
}
