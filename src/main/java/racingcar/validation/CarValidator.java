package racingcar.validation;

import racingcar.model.car.Car;

import static racingcar.type.PlayType.MAX_LENGTH;
import static racingcar.type.PlayType.MIN_LENGTH;

public class CarValidator implements Validator {
    @Override
    public boolean support(Class<?> clazz) {
        return Car.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target) {
        validateLength((String) target);
        validateSpace((String) target);
    }

    private void validateLength(String value){
        if(MIN_LENGTH.getPlayValue() > value.length() || value.length() > MAX_LENGTH.getPlayValue()){
            throw new IllegalArgumentException();
        }
    }

    private void validateSpace(String value){
        if (value.trim().equals("")){
            throw new IllegalArgumentException();
        }
    }
}
