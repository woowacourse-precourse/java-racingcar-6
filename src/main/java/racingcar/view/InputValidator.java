package racingcar.view;

import static racingcar.utils.Parser.COMMA;
import static racingcar.utils.Parser.removeSpacesBetweenCommas;

public class InputValidator {

    private static final String COMMA_PATTERN = "^[,\\p{L}\\p{N}\\s]*$";
    private static final Integer ZERO = 0;
    private static final String BLANK_ERROR = "공백은 허용하지 않습니다.";
    private static final String INTEGER_TYPE_ERROR = "정수 아닌 값은 허용하지 않습니다.";
    private static final String POSITIVE_INTEGER_RANGE_ERROR = "양의 정수 아닌 값은 허용하지 않습니다.";
    private static final String COMMA_ERROR = ",가 아닌 다른 특수문자는 허용하지 않습니다.";
    private static final String LAST_COMMA_ERROR = "입력값 마지막에 ,를 허용하지 않습니다.";

    public static void validateList(String input) {
        validateBlank(input);
        validateSplitComma(input);
    }

    public static void validatePositiveIntegerType(String input) {
        validateBlank(input);
        validateIntegerType(input);
        validatePositive(input);
    }

    private static void validateIntegerType(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(INTEGER_TYPE_ERROR);
        }
    }

    private static void validatePositive(String input) {
        int integer = Integer.parseInt(input);
        if (integer <= ZERO) {
            throw new IllegalArgumentException(POSITIVE_INTEGER_RANGE_ERROR);
        }
    }


    private static void validateSplitComma(String input) {
        String names = removeSpacesBetweenCommas(input);
        if (names.endsWith(COMMA)) {
            throw new IllegalArgumentException(LAST_COMMA_ERROR);
        }
        if (!names.matches(COMMA_PATTERN)) {
            throw new IllegalArgumentException(COMMA_ERROR);
        }
    }

    private static void validateBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(BLANK_ERROR);
        }
    }
}
