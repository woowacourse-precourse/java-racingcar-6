package racingcar.util;

import static racingcar.util.ConstantNumbers.MAXIMUM_NAME_LENGTH;
import static racingcar.util.ConstantNumbers.MINIMUM_TRY_COUNT;

import java.util.List;
import racingcar.util.exception.ErrorMessage;
import racingcar.util.exception.RacingCarException;

public class InputValidator implements Validator {
    InputValidator() {}
    public void isValidList(final List<String> names) {
        for (String name:names) {
            if (!isValidName(name)) {
                throw RacingCarException.of(ErrorMessage.INVALID_NAME);
            }
        }
    }

    public Integer isPositiveInteger(final String count) {
        int number;
        try {
            number = Integer.parseInt(count);
        } catch (Exception e) {
            throw RacingCarException.of(ErrorMessage.NOT_INTEGER);
        }

        if (isNegative(number)) {
            throw RacingCarException.of(ErrorMessage.NOT_POSITIVE);
        }

        return number;
    }
    private boolean isValidName(final String name) {
        return !name.isBlank() && name.length() <= MAXIMUM_NAME_LENGTH.number();
    }

    private boolean isNegative(final int number) {
        return number < MINIMUM_TRY_COUNT.number();
    }
}
