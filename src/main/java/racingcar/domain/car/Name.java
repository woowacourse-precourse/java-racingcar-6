package racingcar.domain.car;

import racingcar.validator.CarNameValidator;

public class Name {
    protected final String name;

    protected Name(String name) {
        CarNameValidator.validateForEachName(name);
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
