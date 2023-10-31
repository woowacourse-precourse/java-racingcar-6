package racingcar.domain;

public class Car {

    public static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    public static final int MINIMUM_FOR_MOVE = 4;
    public static final int MINIMUM_CAR_NAME_LENGTH = 1;

    private final String name;
    private int distance;

    public Car(final String name) {
        validate(name.trim());
        this.name = name.trim();
        this.distance = 0;
    }

    public void move(final int randomNumber) {
        if (randomNumber >= MINIMUM_FOR_MOVE) {
            this.distance++;
        }
    }

    private void validate(final String name) {
        int length = name.length();
        if (length > MAXIMUM_CAR_NAME_LENGTH ||
            length < MINIMUM_CAR_NAME_LENGTH
        ) {
            throw new IllegalArgumentException();
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
