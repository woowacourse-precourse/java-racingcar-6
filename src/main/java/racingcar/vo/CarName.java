package racingcar.vo;

import racingcar.validator.CarNameValidator;

public class CarName {

    private final String value;

    public CarName(final String value) {
        CarNameValidator.validate(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
