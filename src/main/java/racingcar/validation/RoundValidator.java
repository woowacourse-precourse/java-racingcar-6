package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.constant.message.ErrorMessage;
import racingcar.model.Round;

import java.util.regex.Pattern;

public class RoundValidator implements Validator {

    private static final Pattern NUMBER = Pattern.compile(Rule.VALID_RANGE);

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
        if (value != null && !NUMBER.matcher(value).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE);
        }
    }

    private void validateRange(String value) {
        if (0 > Long.parseLong(value)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE);
        }
    }
}
