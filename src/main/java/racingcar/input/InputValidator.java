package racingcar.input;

public class InputValidator {
    public static String validate(String input) {
        if (input == null || input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }
        return input.trim();
    }
}
