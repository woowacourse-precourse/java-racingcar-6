package racingcar.domain;

import static racingcar.validator.CarInputValidator.*;

public class Name {
    private final String name;

    private Name(String name) {
        nameLengthValidate(name);
        nameNullValidate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Name nameOf(String name) {
        return new Name(name);
    }
}
