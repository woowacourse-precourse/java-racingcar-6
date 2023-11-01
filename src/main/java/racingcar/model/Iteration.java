package racingcar.model;

import static racingcar.view.ExceptionMessage.NOT_LESS_THAN_ZERO;

public record Iteration(int value) {
    public Iteration {
        positiveValueValidate(value);
    }

    private void positiveValueValidate(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_LESS_THAN_ZERO.getMessage());
        }
    }
}
