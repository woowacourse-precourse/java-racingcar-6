package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.model.Car;

public class CarValidator implements Validator {
    @Override
    public boolean support(Class<?> clazz) {
        return clazz.isAssignableFrom(Car.class);
    }

    @Override
    public void validate(Object target) {
        validateLength((String) target);
    }

    private void validateLength(String value) {
        if (Rule.MIN_LENGTH > value.length() || value.length() > Rule.MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
