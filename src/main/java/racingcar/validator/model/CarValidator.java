package racingcar.validator.model;

import racingcar.model.Car;

public class CarValidator extends ModelValidator {
    @Override
    public void validate(Object target) {
        Car car = (Car) target;
        new CarNameValidator().validate(car.getCarName());
    }
}