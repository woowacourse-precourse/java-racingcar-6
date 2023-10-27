package racingcar.model;

import static racingcar.error.ErrorMessage.LONG_CAR_NAME;

import java.util.StringJoiner;

public class Car {

    private final String name;

    public Car(final String name) {
        final String trimmedName = name.trim();
        validateLength(trimmedName);
        this.name = trimmedName;
    }

    private void validateLength(final String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(LONG_CAR_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Car.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
