package racingcar.model;

public class Name {
    private final String name;

    public Name(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
