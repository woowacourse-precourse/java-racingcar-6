package racingcar.model;

public class Car {

    private static final int MAX_LENGTH_OF_NAME = 5;

    private final String name;

    public Car(final String name) {
        validateEmptyName(name);
        validateNameLength(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateNameLength(final String name) {
        if(name.length() > MAX_LENGTH_OF_NAME) throw new IllegalArgumentException();
    }

    private void validateEmptyName(final String name) {
        if(name.isEmpty()) throw new IllegalArgumentException();
        if(name.isBlank()) throw new IllegalArgumentException();
    }
}
