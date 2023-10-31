package racingcar.validator;

import constants.ValidatorConstant;

public class CarValidator implements Validator {
    @Override
    public void validate(String name) {
        if (isBlank(name) || isValidCarNameLength(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isBlank(String name) {
        return name == null || name.isBlank();
    }

    private boolean isValidCarNameLength(String name) {
        return name.length() > ValidatorConstant.MAX_CAR_NAME_LENGTH;
    }
}
