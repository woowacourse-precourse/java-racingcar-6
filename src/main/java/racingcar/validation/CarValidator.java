package racingcar.validation;

import racingcar.constant.Rule;
import racingcar.model.car.Car;

public class CarValidator implements Validator {
    @Override
    public boolean support(Class<?> clazz) {
        return Car.class.isAssignableFrom(clazz);
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
