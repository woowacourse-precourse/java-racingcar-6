package racingcar.model;

public class Car {
    private final String name;
    private int positon;

    public Car(final String name) {
        validateName(name);
        this.name = name;
        this.positon = 0;
    }

    private void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        String trimmedName = name.trim();

        if (trimmedName.isEmpty() || trimmedName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
