package racingcar.view;

public class InputValidator {

    private static final String COMMA_PATTERN = "^[,\\p{L}\\p{N}\\s]*$";
    private static final String COMMA_ERROR = ",가 아닌 다른 특수문자는 허용하지 않습니다.";

    public static void validateList(String input) {
        validateSplitComma(input);
    }

    private static void validateSplitComma(String input) {
        if (!input.matches(COMMA_PATTERN)) {
            throw new IllegalArgumentException(COMMA_ERROR);
        }
    }
}
