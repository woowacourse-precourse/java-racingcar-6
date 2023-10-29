package racingcar.validator;

import static racingcar.constant.Constant.MAX_INT_VALUE;
import static racingcar.constant.Constant.MIN_INT_VALUE;

public class RoundCountValidator {

    private static final String ERROR = "[ERROR] ";
    private static final String ERROR_BLANK = ERROR + "공백을 허용하지 않습니다.";
    private static final String ERROR_NON_NUMERIC = ERROR + "숫자를 입력해 주세요." + "입력 값은 1부터 "  + MAX_INT_VALUE + "까지 입니다.";
    private static final String ERROR_NON_ZERO = ERROR + "1 이상인 양수를 입력해 주세요.";
    private static final String ERROR_INT_OVERFLOW = ERROR + "입력 값은 최대 " + MAX_INT_VALUE + "입니다.";

    private RoundCountValidator() {}

    public static void validate(String input) {
        validateBlankException(input);
        validateNumericException(input);
        validatePositiveNumber(input);
        validateIntegerOverflowException(input);
    }

    private static void validateBlankException(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK);
        }
    }

    private static void validateNumericException(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC);
        }
    }

    private static void validatePositiveNumber(String input) {
        int number = Integer.parseInt(input);
        if (number < MIN_INT_VALUE) {
            throw new IllegalArgumentException(ERROR_NON_ZERO);
        }
    }

    private static void validateIntegerOverflowException(String input) {
        long number = Long.parseLong(input);
        if (number > MAX_INT_VALUE || number < MIN_INT_VALUE) {
            throw new IllegalArgumentException(ERROR_INT_OVERFLOW);
        }
    }
}
