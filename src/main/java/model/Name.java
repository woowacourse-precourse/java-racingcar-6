package model;

import static validate.Validator.validateNameLength;

public class Name {
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
