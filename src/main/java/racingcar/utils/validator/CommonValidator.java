package racingcar.utils.validator;

import racingcar.utils.exception.CarExceptionType;

public class CommonValidator implements Validator<String>{
    public CommonValidator() {}

    @Override
    public void validate(final String value) {
        this.validateNotEmpty(value);
    }

    private void validateNotEmpty(final String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(CarExceptionType.INPUT_NULL.getMessage());
        }
    }
}
