package racingcar.model;

public class MovingCountValidator {
    // 이동 횟수 입력값 검증
    public void checkMovementCount(String value) throws IllegalArgumentException {
        try {
            int intValue = Integer.parseInt(value);
            if (intValue <= 0) {
                throw new IllegalArgumentException("에러! 이동 횟수는 1 이상의 정수만 입력해야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("에러! 이동 횟수는 정수만 입력해야 합니다.");
        }
    }
}
