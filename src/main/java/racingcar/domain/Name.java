package racingcar.domain;

public class Name {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        this.name = name;
        validateLength(name);
    }

    private void validateLength(String input) {
        if (input.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
