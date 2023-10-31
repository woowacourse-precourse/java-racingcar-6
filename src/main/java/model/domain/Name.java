package model.domain;

public class Name {

    private final String name;

    public Name(String name) {
        checkNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void checkNameLength(String name) {

        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
