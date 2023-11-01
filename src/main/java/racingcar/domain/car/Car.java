package racingcar.domain.car;

public class Car {
    private final Name name;
    private final Position position;

    public Car(final String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

}
