package racingcar.model.validator;

public class MovingCountValidator {
    public void checkMovementCount(String value) throws IllegalArgumentException {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue <= 0) {
                throw new IllegalArgumentException("에러! 이동 횟수는 1 이상의 정수만 입력해야 합니다.");
            }
            if (intValue > 100) {
                throw new IllegalArgumentException("에러! 이동 횟수는 최대 100까지 입력할 수 있습니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("에러! 이동 횟수는 정수만 입력해야 합니다.");
        }
    }
}
