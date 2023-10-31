package validator;

import static constant.ConstantNumber.MIN_ATTEMPTS;
import static constant.ExceptionString.INVALID_ATTEMPT_MEESAGE;

public class AttemptValidator {
    private AttemptValidator() {
    }

    public static void isPositiveDigit(String attempt) throws IllegalArgumentException {
        int number;
        try {
            number = Integer.parseInt(attempt);
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_MEESAGE);
        }

        if (number < MIN_ATTEMPTS.getValue()) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_MEESAGE);
        }
    }
}
