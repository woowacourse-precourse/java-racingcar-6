package racingcar.vo;

import racingcar.validator.CarNameValidator;


public record CarName(String value) {

    public CarName {
        CarNameValidator.validate(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
