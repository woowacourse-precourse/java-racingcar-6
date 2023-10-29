package racingcar.utils;

public class MovementValidation {

    public void validateMovement(Integer movement) {
        validateNullMovement(movement);
        validateMovementIsPositiveInteger(movement);
    }

    private void validateNullMovement(Integer movement) {
        if (movement == null) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private void validateMovementIsPositiveInteger(Integer movement) {
        if (movement <= 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }
}
