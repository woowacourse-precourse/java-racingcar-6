package racingcar.domain.car;

public class Car {
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return name.toString();
    }

    public int getPosition() {
        return position.getPosition();
    }
}
