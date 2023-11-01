package racingcar.validation;

import racingcar.constant.message.ErrorMessage;
import racingcar.model.Round;

public class RoundValidator implements Validator {

    @Override
    public boolean support(Class<?> clazz) {
        return Round.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateType((String) target);
        validateRange((String) target);
    }

    private void validateType(String value) {
        try {
            Integer.valueOf(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE);
        }
    }

    private void validateRange(String value) {
        if (0 > Integer.parseInt(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
