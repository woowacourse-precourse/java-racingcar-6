package racingcar.utils;

public class MovementValidation {

    private static final String NULL_MOVEMENT_MESSAGE = "아무것도 입력하지 않았습니다.";
    private static final String ZERO_MOVEMENT_MESSAGE = "이동회수는 0을 입력할 수 없습니다.";
    private static final String NEGATIVE_MOVEMENT_MESSAGE = "음수는 입력할 수 없습니다.";
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
