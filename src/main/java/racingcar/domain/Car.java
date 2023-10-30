package racingcar.domain;

public class Car {

    private final int ZERO = 0;
    private final int THRESHOLD = 4;
    private final CarName carName;
    private Position position;

    public Car(final CarName carName) {
        this.carName = carName;
        this.position = new Position(ZERO);
    }

    public void moveToCar(final int value) {
        if (value >= THRESHOLD) {
            position = position.move();
        }
    }

    public String getName() {
        return carName.name();
    }

    public int getPosition() {
        return position.position();
    }
}
