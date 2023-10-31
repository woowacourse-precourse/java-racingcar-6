package racingcar.model;

public class Car {
    private final CarName carName;
    private int position;

    private Car(final String name) {
        this.carName = new CarName(name);
        this.position = 0;
    }

    public static Car from(final String carName) {
        return new Car(carName);
    }

    public void moveForward() {
        this.position++;
    }

    public final int getPosition() {
        return this.position;
    }

    public final String getName() {
        return this.carName.getName();
    }
}
