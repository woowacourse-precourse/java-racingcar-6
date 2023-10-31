package racingcar;

public class Car {

    private static final int MIN_FORWARD_SPEED = 4;

    private final CarName name;

    private int position;

    private Car(final CarName name, final int position) {
        this.name = name;
        this.position = position;
    }

    public static Car withName(final String name) {
        return new Car(CarName.valueOf(name), 0);
    }

    public void moveForward(final int speed) {
        if (speed >= MIN_FORWARD_SPEED) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
