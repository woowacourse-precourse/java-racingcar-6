package racingcar.validation;

import racingcar.exception.ExceptionMessage;

public class NumberValidator implements Validator {
    private static final NumberValidator instance = new NumberValidator();

    private NumberValidator() {
    }

    public static NumberValidator getInstance() {
        return instance;
    }

    @Override
    public void validate(final String target) {
        validateNotNull(target);
        validateDigit(target);
    }

    private void validateDigit(final String target) {
        for (final char c : target.toCharArray()) {
            if (!Character.isDigit(c)) {
                throwFail(ExceptionMessage.MUST_BE_DIGIT.format());
            }
        }
    }
}
