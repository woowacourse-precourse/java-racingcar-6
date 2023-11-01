package racingcar.model;

import racingcar.validator.BasicValidator;
import racingcar.validator.NameValidator;

public record Name(String name) {

    private static final BasicValidator<String> carNameValidator = new NameValidator();

    public Name {
        carNameValidator.validate(name);
    }

    public static Name init(String carName) {
        return new Name(carName);
    }
}
