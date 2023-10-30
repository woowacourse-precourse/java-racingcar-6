package racingcar.domain;


public class Car {

    private final CarName carName;
    private Position position = new Position(0);

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
