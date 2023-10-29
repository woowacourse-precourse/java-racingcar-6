package racingcar.model;

import static racingcar.message.ExceptionMessage.LENGTH_LIMIT_EXCEEDED;

public class CarName {

    private static final int LENGTH_LIMIT = 5;

    private final String name;

    private CarName(final String name) {
        validate(name);
        this.name = name;
    }

    public static CarName from(final String name) {
        return new CarName(name);
    }

    private void validate(final String name) {
        if (name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException(LENGTH_LIMIT_EXCEEDED.getMessage());
        }
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof CarName carName
                && name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
