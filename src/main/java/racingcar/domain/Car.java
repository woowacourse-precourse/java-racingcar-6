package racingcar.domain;

public class Car {
    private final CarName carName;
    private Position position;

    public Car(CarName carName, Position position) {
        this.carName = carName;
        this.position = position;
    }

    public void move(Strategy strategy) {
        this.position = position.move();
    }

    public Position getPosition() {
        return position;
    }
}
