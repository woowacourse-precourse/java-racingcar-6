package racingcar.validator;

import static racingcar.constants.ValidatorConstant.*;

public class CarValidator implements Validator {
    @Override
    public void validate(String name) {
        if (isBlank(name) || isValidCarNameLength(name)) {
            throw new IllegalArgumentException(CAR_NAME_ERROR_MESSAGE);
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isValidCarNameLength(String name) {
        return name.length() > MAX_CAR_NAME_LENGTH;
    }
}