package racingcar.validator;

public class MoveCountValidator {

    private MoveCountValidator() {
    }

    public static void validateInputFormat(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("횟수는 숫자만 입력할 수 있습니다.");
        }
    }
}
