package racingcar.domain;

public class Car {

    public static final int CAR_NAME_LENGTH = 5;
    public static final int MINIMUM_FOR_MOVE = 4;

    private final String name;
    private int distance;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.distance = 0;
    }

    public void move(int randomNumber) {
        if (randomNumber >= MINIMUM_FOR_MOVE) {
            this.distance++;
        }
    }

    private void validate(String name) {
        if (name.length() > CAR_NAME_LENGTH) {
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
