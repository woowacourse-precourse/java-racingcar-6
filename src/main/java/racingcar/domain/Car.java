package racingcar.domain;


public class Car {

    private final CarName name;
    private Position position = new Position(0);

    public Car(final CarName name) {
        this.name = name;
    }

    public CarName getName() {
        return this.name;
    }

    public void moveToCar() {
        this.position = position.move();
    }

    public Position getPosition() {
        return this.position;
    }
}
