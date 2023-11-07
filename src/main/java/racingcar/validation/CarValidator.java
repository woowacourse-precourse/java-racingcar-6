package racingcar.validation;

import racingcar.model.Car;

import static racingcar.type.PlayType.MAX_LENGTH;
import static racingcar.type.PlayType.MIN_LENGTH;

public class CarValidator implements Validator {
    @Override
    public boolean support(Class<?> clazz) {
        return clazz.isAssignableFrom(Car.class);
    }

    @Override
    public void validate(Object target) {
        validateLength((String) target);
    }

    private void validateLength(String value){
        if(MIN_LENGTH.getPlayValue() > value.length() || value.length() > MAX_LENGTH.getPlayValue()){
            throw new IllegalArgumentException();
        }
    }
}
