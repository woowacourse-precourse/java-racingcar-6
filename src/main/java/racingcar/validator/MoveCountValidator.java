package racingcar.validator;

import racingcar.util.Convertor;

public class MoveCountValidator {

    private MoveCountValidator() {
    }

    public static void validate(String input) {
        validateNull(input);
        validateInputFormat(input);
        validateMoveCount(input);
        validateIsStartZero(input);
    }

    private static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("아무런 값을 입력하지 않았습니다.");
        }
    }

    private static void validateInputFormat(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("횟수는 숫자만 입력할 수 있습니다.");
        }
    }

    private static void validateMoveCount(String input) {
        int moveCount = Convertor.convertStringToInt(input);
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동 횟수는 0보다 커야 합니다.");
        }
    }

    private static void validateIsStartZero(String input) {
        if (input.charAt(0) == '0') {
            Integer.parseInt(input);
            throw new IllegalArgumentException("이동 횟수의 첫 번째 숫자는 0이 될 수 없습니다.");
        }
    }
}
