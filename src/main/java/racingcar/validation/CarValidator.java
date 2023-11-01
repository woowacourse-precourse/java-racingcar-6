package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.constant.message.ErrorMessage;
import racingcar.model.car.Car;

import java.util.regex.Pattern;

public class CarValidator implements Validator {

    private static final Pattern ALPHANUMERIC_HANGUL_PATTERN = Pattern.compile("^[ㄱ-ㅎ가-힣a-zA-Z0-9 ]+$");

    @Override
    public boolean support(Class<?> clazz) {
        return Car.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateType((String) target);
        validateLength((String) target);
        validateSpace((String) target);
    }

    private void validateType(String value) {
        if (value == null || !ALPHANUMERIC_HANGUL_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TYPE);
        }
    }

    private void validateLength(String value) {
        if (Rule.MIN_LENGTH > value.length() || value.length() > Rule.MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LENGTH);
        }
    }

    private void validateSpace(String value) {
        if (value.trim().equals("")) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_SPACE);
        }
    }
}
