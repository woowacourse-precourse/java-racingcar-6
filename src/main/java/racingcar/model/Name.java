package racingcar.model;

import racingcar.validator.NameLengthValidator;

public class Name {
    private final String name;

    public Name(String name) {
        NameLengthValidator nameLengthValidator = new NameLengthValidator();
        nameLengthValidator.validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
