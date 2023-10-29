package racingcar.model;

public class Car {
    private static final int MIN_MOVE_NUMBER = 4;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        position = new Position();
    }

    public void decideToMove(int randomNumber) {
        if (randomNumber >= MIN_MOVE_NUMBER) {
            position.movePosition();
        }
    }

    public String getDisplayFormat() {
        return name.getDisplayFormat() + " : " + position.getDisplayFormat();
    }

    public Position position() {
        return this.position;
    }

    public Name name() {
        return this.name;
    }
}
