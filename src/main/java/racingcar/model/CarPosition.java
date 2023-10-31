package racingcar.model;

import racingcar.model.validators.CarPositionValidator;
import racingcar.model.validators.Validator;

public class CarPosition {
    private int value;

    private static final Validator validator = new CarPositionValidator();

    public CarPosition(Integer value) {
        validator.validate(value);
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
