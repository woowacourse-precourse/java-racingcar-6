package racingcar.model;

import racingcar.validator.NameLengthValidator;

public class Name {
    public Name(String name) {
        NameLengthValidator nameLengthValidator = new NameLengthValidator();
        nameLengthValidator.validate(name);
    }
}
