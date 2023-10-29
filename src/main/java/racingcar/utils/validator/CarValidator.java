package racingcar.utils.validator;

import racingcar.utils.types.StringUtils;

public class CarValidator extends CarCommonValidator{

    private static final int START_LENGTH = 1;
    private static final int END_LENGTH = 5;

    public CarValidator() {
    }

    @Override
    public void validate(final String value) {
        super.validate(value);
        this.validateNameLength(value);
    }

    private void validateNameLength(final String value) {
        if (!StringUtils.isLengthInRange(value, START_LENGTH, END_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }
}
