package racingcar.vo.car;

import racingcar.exception.car.NameValidator;

public class Name {

    private final String value;

    public Name(final String value) {
        NameValidator.validate(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
