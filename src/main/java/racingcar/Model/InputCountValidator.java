package racingcar.Model;

public class InputCountValidator {
    private static final InputCountValidator singleton = new InputCountValidator();
    private static final String ERROR_MESSAGE_FOR_MIN = "시도 횟수는 1 이상이어야 합니다.";
    private static final int MINIMUM_COUNT = 1;

    public static InputCountValidator getInstance() {
        return singleton;
    }

    public int validateCount(String racingCount) {
        isNumber(racingCount);
        int count = Integer.parseInt(racingCount);
        isMin(count);
        return count;
    }

    private void isMin(int count) {
        if (count < MINIMUM_COUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_MIN);
        }
    }

    // 문자열 입력 시 예외처리
    private void isNumber(String racingCount) {
        try {
            Integer.parseInt(racingCount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(e.getMessage());
        }
    }
}
