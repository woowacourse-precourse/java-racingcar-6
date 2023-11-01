package racingcar.domain.car;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final Name name) {
        this.name = name;
        this.position = new Position();
    }
}
