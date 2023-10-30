package racingcar.util.validator;

import racingcar.exception.ExceptionMessage;

public class NumberValidator implements Validator {
    private static final Validator INSTANCE = new NumberValidator();

    private NumberValidator() {
    }

    public static Validator getInstance() {
        return INSTANCE;
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
