package racingcar.util.validator;

import racingcar.exception.ExceptionMessage;

public class CarNameValidator implements Validator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final Validator INSTANCE = new CarNameValidator();

    private CarNameValidator() {
    }

    public static Validator getInstance() {
        return INSTANCE;
    }

    @Override
    public void validate(final String target) {
        validateNotNull(target);
        validateNotBlank(target);
        validateLengthFiveOrLess(target);
    }

    private void validateNotBlank(final String target) {
        if (target.isBlank()) {
            throwFail(ExceptionMessage.NOT_BLANK.format());
        }
    }

    private void validateLengthFiveOrLess(final String target) {
        if (target.length() > MAX_CAR_NAME_LENGTH) {
            throwFail(ExceptionMessage.INVALID_MAX_LENGTH.format(MAX_CAR_NAME_LENGTH));
        }
    }
}
