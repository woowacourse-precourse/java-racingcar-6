package racingcar;

import racingcar.validator.NameValidator;
import racingcar.validator.Validator;

public record CarName(String name) {

    public CarName {
        throwIfInvalidName(name);
    }

    private void throwIfInvalidName(String name) {
        Validator validator = new NameValidator();
        validator.validate(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
