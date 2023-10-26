package racingcar.domain;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position(0);
    }
}
