package racingcar.domain.car;

import racingcar.constant.errorMessage.ErrorMessages;
import racingcar.constant.errorMessage.InvalidArgumentException;

public class CarNameValidator {

    private static final int NAME_LENGTH_LIMIT = 5;

    private CarNameValidator() {
    }

    public static void validateCarName(final String name) {
        validateCarNameIsTooLong(name);
    }

    private static void validateCarNameIsTooLong(final String name) {
        if (isTooLong(name)) {
            throw new InvalidArgumentException(ErrorMessages.CAR_NAME_IS_TOO_LONG);
        }
    }

    private static boolean isTooLong(final String name) {
        return name.length() > NAME_LENGTH_LIMIT;
    }
}
