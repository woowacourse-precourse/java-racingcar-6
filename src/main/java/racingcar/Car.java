package racingcar;

public class Car {

    private final CarName name;

    private int position;

    public Car(final String name, final int position) {
        this.name = CarName.create(name);
        this.position = position;
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
