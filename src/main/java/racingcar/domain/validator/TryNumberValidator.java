package racingcar.domain.validator;

import racingcar.domain.validator.exception.TryNumberException;

public class TryNumberValidator implements InputValidator {
    @Override
    public void validate(String input) {
        int intValueInput = 0;

        if (input.isEmpty()) {
            throw new IllegalArgumentException(TryNumberException.NO_VALUE_TRY_NUMBER.getMessage());
        }

        try {
            intValueInput = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(TryNumberException.INVALID_INTEGER_VALUE.getMessage());
        }

        if (intValueInput >=10) {
            throw new IllegalArgumentException(TryNumberException.INVALID_TOO_BIG_TRY_NUMBER.getMessage());
        }

        if (intValueInput <=1) {
            throw new IllegalArgumentException(TryNumberException.INVALID_TOO_SMALL_TRY_NUMBER.getMessage());
        }
    }
}
