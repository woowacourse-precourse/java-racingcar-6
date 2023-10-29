package racingcar.model;

import racingcar.validator.NameValidator;

public class Name {
    private final String name;

    public Name(String name) {
        NameValidator.INSTANCE.validateName(name);

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
