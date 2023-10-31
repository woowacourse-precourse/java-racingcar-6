package racingcar.validator;

import static racingcar.constant.ErrorMessage.*;

public class AttemptNumberValidator {
    public static int validateNumber(String number) {
        if (number == null || number.trim().isEmpty()) {
            throw new IllegalArgumentException(ATTEMPTS_EMPTY_ERROR);
        }

        try {
            int attempts = Integer.parseInt(number);
            if (attempts <= 0) {
                throw new IllegalArgumentException(INVALID_ATTEMPTS_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ATTEMPTS_FORMAT_ERROR);
        }

        return Integer.parseInt(number);
    }
}