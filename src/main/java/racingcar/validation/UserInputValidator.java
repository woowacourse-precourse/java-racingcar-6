package racingcar.validation;

public class UserInputValidator {

    public static final String EMPTY_NOT_ALLOWED = "빈 문자열을 입력할 수 없습니다.";
    public static final String BLANK_NOT_ALLOWED = "공백으로만 된 문자열을 입력할 수 없습니다.";

    public static void validateUserInput(String userInput) {
        validateIsEmpty(userInput);
        validateIsNull(userInput);
    }

    private static void validateIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NOT_ALLOWED);
        }
    }

    private static void validateIsNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED);
        }
    }

}

