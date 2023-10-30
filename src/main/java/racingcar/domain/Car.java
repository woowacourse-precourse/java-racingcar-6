package racingcar.domain;

public class Car {
    private final String name;
    private int position;
    private static final int CAR_SPEED = 1;

    public Car(final String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForward() {
        position += CAR_SPEED;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
