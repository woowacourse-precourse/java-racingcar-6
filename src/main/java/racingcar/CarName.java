package racingcar;

public class CarName {

    private final String name;

    private CarName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isNullOrEmpty(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNullOrEmpty(final String name) {
        return name == null || name.isBlank();
    }

    public static CarName of(final String name) {
        return new CarName(name);
    }
}
