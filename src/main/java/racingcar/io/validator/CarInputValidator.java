package racingcar.io.validator;

import java.util.List;

import static racingcar.exception.ExceptionMessage.InputException.CAR_HAS_INVALID_CHARACTER;

public class CarInputValidator {
    public void validate(final List<String> cars) {
        cars.forEach(this::checkValidCharacter);
    }

    private void checkValidCharacter(final String car) {
        for (final char part : car.toCharArray()) {
            if (isInvalidCharacter(part)) {
                throw new IllegalArgumentException(CAR_HAS_INVALID_CHARACTER.message);
            }
        }
    }

    private boolean isInvalidCharacter(final char part) {
        return !Character.isDigit(part) && !Character.isLetter(part);
    }
}
