package racingcar.validator;

public class InputValidator {
    public void validateTryCount(String input) {
        validateIsNaturalNumber(input);
    }

    public void validateIsNaturalNumber(String input) {
        try {
            int value = Integer.parseInt(input);
            if (value <= 0) {
                throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수만 입력 가능합니다.");
        }
    }
}
