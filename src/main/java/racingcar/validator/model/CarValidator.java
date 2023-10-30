package racingcar.validator.model;

import racingcar.model.Car;

public class CarValidator extends ModelValidator {
    private static CarValidator carValidator = new CarValidator();

    private CarValidator() {
    }

    public static CarValidator getInstance() {
        return carValidator;
    }

    @Override
    public void validate(Object target) {
        Car car = (Car) target;
        CarNameValidator.getInstance()
                .validate(car.getCarName());
    }
}
