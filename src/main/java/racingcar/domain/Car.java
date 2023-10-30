package racingcar.domain;


public class Car {

    private final CarName carName;
    private final int ZERO = 0;
    private Position position = new Position(ZERO);

    public Car(final CarName carName) {
        this.carName = carName;
    }

    public void moveToCar(final int value) {
        if (value >= 4) {
            this.position = position.move();
        }
    }

    public String getName() {
        return this.carName.name();
    }

    public int getPosition() {
        return this.position.position();
    }
}
