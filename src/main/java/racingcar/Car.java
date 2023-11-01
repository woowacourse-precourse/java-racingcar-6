package racingcar;

public class Car {

    private final Name name;
    private final Position position;

    public Car(String nameValue) {
        this.name = new Name(nameValue);
        this.position = new Position();
    }

    public void move(Movement movement) {
        position.move(movement);
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position.getValue();
    }

    @Override
    public String toString() {
        return name.toString();
    }
}