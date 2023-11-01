package racingcar.model;

import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.Validator;

public class CarName {
    private final String name;

    public CarName(final String name) {
        final Validator validator = CarNameValidator.getInstance();
        validator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
