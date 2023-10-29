package racingcar.validation;

public class UserInputValidator {

    public static final String EMPTY_NOT_ALLOWED = "빈 문자열을 입력할 수 없습니다.";
    public static final String BLANK_NOT_ALLOWED = "공백으로만 된 문자열을 입력할 수 없습니다.";
    public static final String ONLY_NUMBER_ALLOWED = "숫자만 입력할 수 있습니다.";
    public static final String POSITIVE_NUMBER_ALLOWED = "0또는 음수는 입력할 수 없습니다.";

    public static final int MIN_NUMBER = 1;

    public static void validateUserInput(String userInput) {
        validateIsEmpty(userInput);
        validateIsNull(userInput);
    }

    public static void validateNumberOfRetriesInput(String userInput) {
        validateIsNumber(userInput);
        validateIsPositive(userInput);
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

    private static void validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED);
        }
    }

    private static void validateIsPositive(String input) {
        if (Integer.parseInt(input) >= MIN_NUMBER) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ALLOWED);
        }
    }

}

