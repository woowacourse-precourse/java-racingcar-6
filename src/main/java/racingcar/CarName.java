package racingcar;

public class CarName {

    private static final int ALLOWED_LETTERS = 5;
    private final String name;

    private CarName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (isNullOrEmpty(name) || isExceedNumberOfLetters(name)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNullOrEmpty(final String name) {
        return name == null || name.isBlank();
    }

    private boolean isExceedNumberOfLetters(final String name) {
        return name.length() > ALLOWED_LETTERS;
    }

    public static CarName create(final String name) {
        return new CarName(name);
    }
}
