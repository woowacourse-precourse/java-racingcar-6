package racingcar.model;

import static racingcar.validator.Validator.checkInputCarNames;

public class Name {

    private final String name;

    public Name(String name) {
        checkInputCarNames(name);
        this.name = name;
    }

    public static Name from(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
