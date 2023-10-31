package racingcar.validation;

public class MoveCountsValidation {
    public void validateMoveCountsInput(String input) {
        if (!isInteger(input)) {
            throw new IllegalArgumentException("정수만 입력이 가능합니다.");
        }
        int moveCounts = Integer.parseInt(input);
        if (moveCounts < 1) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해야 합니다.");
        }
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
