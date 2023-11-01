package racingcar.domain;

public class Car {

    private final int MOVE_FORWARD_MIN = 4;

    private Name name;
    private Position position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public void goForwardByNumber(int number) {
        if (number >= MOVE_FORWARD_MIN) {
            position.increase();
        }
    }

    public boolean isWinner(int maxPositionNumber) {
        return position.getPosition() == maxPositionNumber;
    }

    public Name getName() {
        return name;
    }

    public int getPositionNumber() {
        return position.getPosition();
    }

    @Override
    public String toString() {
        return name.toString() + " : " + position.createLine();
    }

}