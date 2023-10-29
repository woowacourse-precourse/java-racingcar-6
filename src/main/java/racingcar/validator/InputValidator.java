package racingcar.validator;

public class InputValidator {
    private void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }
}
