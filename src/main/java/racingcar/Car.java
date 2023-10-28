package racingcar;

public class Car {

    private final CarName name;

    private int position;

    private Car(final String name, final int position) {
        this.name = CarName.create(name);
        this.position = position;
    }

    public static Car withName(final String name) {
        return new Car(name, 0);
    }

    public void move(final int speed) {
        if (speed >= 4) {
            position += 1;
        }
    }

    public int getPosition() {
        return position;
    }
}
