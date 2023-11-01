package racingcar.domain;

import racingcar.validator.CarNameValidator;

public record CarName(String value) {

    public String getValue() {
        return value;
    }

    public static CarName from(final String name) {
        CarNameValidator.validate(name);
        return new CarName(name);
    }
}
