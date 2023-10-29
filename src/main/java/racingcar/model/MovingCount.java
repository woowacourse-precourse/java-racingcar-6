package racingcar.model;

import static racingcar.constant.InputError.EXCEEDED_LIMIT_CAR_LENGTH;

public final class MovingCount {
    private final int count;

    private MovingCount(String input) {
        validateInputIsDigit(input);
        this.count = Integer.parseInt(input);
    }

    public static MovingCount createMovingCount(String input) {
        return new MovingCount(input);
    }

    private void validateInputIsDigit(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(EXCEEDED_LIMIT_CAR_LENGTH.getMessage());
        }
    }

    public boolean isNotEqual(int i) {
        return count != i;
    }
}
