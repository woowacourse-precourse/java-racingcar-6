package racingcar.utils;

import static racingcar.message.IllegalArgumentExceptionMessage.*;

public class MovementValidation {
    private static final Integer MIN_MOVEMENT = 0;


    public void validateMovement(Integer movement) {
        validateNullMovement(movement);
        validateMovementIsZero(movement);
        validateMovementIsPositiveInteger(movement);
    }

    private void validateNullMovement(Integer movement) {
        if (movement == null) {
            throw new IllegalArgumentException(NULL_MOVEMENT_MESSAGE);
        }
    }

    private void validateMovementIsZero(Integer movement) {
        if (movement == MIN_MOVEMENT) {
            throw new IllegalArgumentException(ZERO_MOVEMENT_MESSAGE);
        }
    }

    private void validateMovementIsPositiveInteger(Integer movement) {
        if (movement < MIN_MOVEMENT) {
            throw new IllegalArgumentException(NEGATIVE_MOVEMENT_MESSAGE);
        }
    }
}
