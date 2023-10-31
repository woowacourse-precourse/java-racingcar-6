package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LEGNTH = 5;

    private final int location;

    private final String name;

    private Car(String name) {
        this.location = 0;
        this.name = name;
    }

    public static Car getInstance(final String name) {
        validateLengthOfName(name);
        return new Car(name);
    }

    private static void validateLengthOfName(final String name) {
        if (name.length() > MAX_NAME_LEGNTH) {
            throw new IllegalArgumentException();
        }
    }
}
