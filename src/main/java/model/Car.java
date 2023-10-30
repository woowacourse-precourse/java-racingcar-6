package model;

public class Car {

    private final Name name;
    private final MoveCount moveCount;

    private Car(final Name name, final MoveCount moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public static Car from(final String value) {
        Name name = Name.from(value);
        MoveCount count = MoveCount.initialMoveCount();
        return new Car(name, count);
    }

    public void moveForward() {
        moveCount.moveForward();
    }

    public String getNameValue() {
        return name.getName();
    }

    public int getMoveCountValue() {
        return moveCount.getMoveCount();
    }

    public boolean hasSameMoveCount(final int count) {
        return moveCount.hasSameValue(count);
    }
}
