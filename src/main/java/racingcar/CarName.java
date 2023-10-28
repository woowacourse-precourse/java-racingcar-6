package racingcar;

public class CarName {

    private static final int MAX_LENGTH = 5;
    private final String name;

    private CarName(final String name) {
        validateBlank(name);
        validateLength(name);
        this.name = name;
    }

    private void validateBlank(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateLength(final String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public static CarName create(final String name) {
        return new CarName(name);
    }
}
