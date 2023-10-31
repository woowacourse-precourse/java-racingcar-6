package racingcar.model;


import racingcar.model.validators.CarNameValidator;
import racingcar.model.validators.Validator;

public class CarName {
    private final String value;

    private static final Validator validator = new CarNameValidator();

    public CarName(String value) {
        validator.validate(value);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
