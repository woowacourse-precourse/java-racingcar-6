package racingcar.domain;

public class Car implements Comparable<Car> {

    private static final int MIN_MOVABLE_VALUE = 4;
    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void MoveOrStop(int randomNumber) {
        if (canMove(randomNumber)) {
            position.move();
        }
    }

    private boolean canMove(int randomNumber) {
        return randomNumber >= MIN_MOVABLE_VALUE;
    }

    @Override
    public int compareTo(Car other) {
        return this.position.compareTo(other.position);
    }

    public boolean isSamePosition(Car other) {
        return this.position.isSamePosition(other.position);
    }

    public String getName() {
        return name.getLawName();
    }

    public int getPosition() {
        return position.getLawPosition();
    }
}
