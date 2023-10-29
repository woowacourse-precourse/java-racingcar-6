package racingcar.domain.car;

import racingcar.utils.CarValidator;

public class Name {
    private final String name;

    public Name(String name) {
        CarValidator.validateName(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
