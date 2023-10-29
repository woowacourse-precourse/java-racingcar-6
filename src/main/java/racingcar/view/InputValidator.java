package racingcar.view;

import static racingcar.utils.Parser.COMMA;

public class InputValidator {

    private static final String COMMA_PATTERN = "^[,\\p{L}\\p{N}\\s]*$";
    private static final String BLANK_ERROR = "공백은 허용하지 않습니다.";
    private static final String COMMA_ERROR = ",가 아닌 다른 특수문자는 허용하지 않습니다.";
    private static final String LAST_COMMA_ERROR = "입력값 마지막에 ,를 허용하지 않습니다.";

    public static void validateList(String input) {
        validateBlank(input);
        validateSplitComma(input);
    }

    private static void validateSplitComma(String input) {
        if (input.endsWith(COMMA)) {
            throw new IllegalArgumentException(LAST_COMMA_ERROR);
        }
        if (!input.matches(COMMA_PATTERN)) {
            throw new IllegalArgumentException(COMMA_ERROR);
        }
    }

    private static void validateBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }
}
