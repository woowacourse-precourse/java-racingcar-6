package racingcar.validation;

import racingcar.constant.Rule;
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
        if (value != null && !value.matches(Rule.VALID_RANGE)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(String value) {
        if (0 > Long.parseLong(value)) {
            throw new IllegalArgumentException();
        }
    }
}
