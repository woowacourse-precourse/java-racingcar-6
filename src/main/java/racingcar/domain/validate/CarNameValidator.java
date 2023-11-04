package racingcar.domain.validate;

import racingcar.util.StringManipulator;
import racingcar.domain.validate.exception.CarNameException;

import java.util.List;

public class CarNameValidator implements InputValidator {
    @Override
    public void validate(String input) {
        check_null(input);
        List<String> trimmedInputs = StringManipulator.split(input);
        trimmedInputs.forEach(this::check_length);
    }

    private void check_null(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(CarNameException.NO_VALUE_NAME.getMessage());
        }
    }

    private void check_length(String sentence) {
        if (sentence.length() >=6) {
            throw new IllegalArgumentException(CarNameException.INVALID_TOO_LONG_NAME.getMessage());
        }

        if (sentence.length() <=2) {
            throw new IllegalArgumentException(CarNameException.INVALID_TOO_SHORT_NAME.getMessage());
        }
    }
}