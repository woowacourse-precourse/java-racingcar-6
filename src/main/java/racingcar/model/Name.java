package racingcar.model;

public class Name {
    private final String name;

    public Name(String name) {
        validateLength(name);
        validateBlank(name);

        this.name = name.strip();
    }

    public String getName() {
        return this.name;
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
