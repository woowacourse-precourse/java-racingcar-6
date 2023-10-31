package racingcar.validation;

public class UserInputValidator {

    public static final String EMPTY_NOT_ALLOWED = "빈 문자열을 입력할 수 없습니다.";
    public static final String BLANK_NOT_ALLOWED = "공백으로만 된 문자열을 입력할 수 없습니다.";
    public static final String ONLY_NUMBER_ALLOWED = "숫자만 입력할 수 있습니다.";
    public static final String POSITIVE_NUMBER_ALLOWED = "0또는 음수는 입력할 수 없습니다.";
    public static final String BOTH_ENDS_COMMA_NOT_ALLOWED = "쉼표는 문자 양 끝에 있을 수 없습니다.";

    public static final int MIN_LENGTH_ALLOWED = 1;
    public static final String COMMA = ",";

    public static void validateUserInput(String userInput) {
        validateEmpty(userInput);
        validateNull(userInput);
        validateBothEndsRest(userInput);
    }

    public static void validateNumberOfRetriesInput(String userInput) {
        validateNumber(userInput);
        validatePositiveNumber(userInput);
    }

    private static void validateEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NOT_ALLOWED);
        }
    }

    private static void validateNull(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_NOT_ALLOWED);
        }
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ONLY_NUMBER_ALLOWED);
        }
    }

    private static void validatePositiveNumber(String input) {
        if (Integer.parseInt(input) < MIN_LENGTH_ALLOWED) {
            throw new IllegalArgumentException(POSITIVE_NUMBER_ALLOWED);
        }
    }

    private static void validateBothEndsRest(String input) {
        if (input.startsWith(COMMA) || input.endsWith(COMMA)) {
            throw new IllegalArgumentException(BOTH_ENDS_COMMA_NOT_ALLOWED);
        }
    }

}

