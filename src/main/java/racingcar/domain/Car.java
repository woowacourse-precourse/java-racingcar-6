package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;

    private int location;

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
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward() {
        this.location += 1;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        stringBuilder.append("-".repeat(location));
        return stringBuilder.toString();
    }
}
