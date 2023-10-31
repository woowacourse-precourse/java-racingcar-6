package racingcar.validator;

import static java.lang.Integer.parseInt;
import static racingcar.exception.ErrorMessage.*;

public class TryCountValidator {

    private TryCountValidator() {

    }

    public static void validate(String tryCount) {
        validateEmpty(tryCount);
        validateDigit(tryCount);
        validateSign(tryCount);
    }

    private static void validateEmpty(String tryCount) {
        if (tryCount.isEmpty()) {
            throw new IllegalArgumentException(VALIDATE_EMPTY_FOR_INPUT_STRING.getMessage());
        }
    }

    private static void validateDigit(String tryCount) {
        if (tryCount.chars().anyMatch(ch -> !Character.isDigit(ch))) {
            throw new IllegalArgumentException(VALIDATE_DIGIT_FOR_INPUT_STRING.getMessage());
        }
    }

    private static void validateSign(String tryCount) {
        if (parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException(VALIDATE_SIGN_FOR_INPUT_STRING.getMessage());
        }
    }
}
