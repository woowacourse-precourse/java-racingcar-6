package racingcar.model;

import racingcar.validator.NameValidator;

public class Name {
    private final String name;

    public Name(String name) {
        NameValidator validator = NameValidator.INSTANCE;
        validator.validateName(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
