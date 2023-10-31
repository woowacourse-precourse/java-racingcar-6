package racingcar.model;

import racingcar.util.validator.NameValidator;

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
