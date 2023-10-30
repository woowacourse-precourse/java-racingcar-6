package racingcar.domain.valueobject;

import racingcar.domain.validator.NameValidator;

public class CarName {
    private String name;

    public CarName(String name) {
        NameValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
