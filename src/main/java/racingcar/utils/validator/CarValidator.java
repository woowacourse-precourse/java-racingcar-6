package racingcar.utils.validator;

import racingcar.utils.types.StringUtils;

public class CarValidator implements Validator<String>{

    private static final int START_LENGTH = 1;
    private static final int END_LENGTH = 5;

    public CarValidator() {
    }

    @Override
    public void validate(final String value) {
        this.validateNameNotEmpty(value);
        this.validateNameLength(value);
    }

    private void validateNameNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameLength(final String value) {
        if (!StringUtils.isLengthInRange(value, START_LENGTH, END_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }
}
