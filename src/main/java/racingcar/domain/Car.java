package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private int location;

    private final String name;

    public Car(String name) {
        validateLengthOfName(name);
        this.location = 0;
        this.name = name;
    }

    private static void validateLengthOfName(final String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public void moveForward() {
        this.location += 1;
    }

    public int getLocation() {
        return location;
    }

    public void addToWinner(final Winners winners) {
        winners.addNameOfWinner(name);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name + " : ");
        stringBuilder.append("-".repeat(location));
        return stringBuilder.toString();
    }
}
