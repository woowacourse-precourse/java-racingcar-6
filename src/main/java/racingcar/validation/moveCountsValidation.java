package racingcar.validation;

public class moveCountsValidation {
    public void validateMoveCountsInput(String input) {
        validateNumber(input);
        validateRange(input);
        validateInteger(input);
    }

    private void validateNumber(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private void validateRange(String input) {
        int moveCounts = parseMoveCounts(input);
        if (moveCounts <= 0) {
            throw new IllegalArgumentException("1 이상의 정수를 입력해야 합니다.");
        }
    }

    private int parseMoveCounts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자 형식이 아닙니다.");
        }
    }

    private void validateInteger(String input) {
        try {
            int moveCounts = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력이 가능합니다.");
        }
    }
}
