package validator;

import static constant.ConstantNumber.MIN_ATTEMPTS;
import static constant.ExceptionString.INVALID_ATTEMPT_MEESAGE;

public class AttemptValidator {
    private AttemptValidator() {
    }

    public static void isDigit(String attempt) {
        try {
            int number = Integer.parseInt(attempt);
            if (number < MIN_ATTEMPTS.getValue()) {
                throw new IllegalArgumentException(INVALID_ATTEMPT_MEESAGE);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(INVALID_ATTEMPT_MEESAGE);
        }
    }
}
