package racingcar.domain;

import static racingcar.util.Validator.*;

public class Name {
    private String name;
    private Name(String name) {
        validateEmpty(name);
        validateLength(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
