package racingcar.domain.car;

public class Car {

    private static final int MOVE_STANDARD = 4;
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        position.moveForward();;
    }

    public int getPosition() {
        return position.getPosition();
    }

    public String getName() {
        return name.getName();
    }
}
