package model;

public class Car {

    private final Name name;
    private final Count moveCount;

    private Car(final Name name, final Count moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public static Car from(final String value) {
        Name name = Name.from(value);
        Count count = Count.initialCount();
        return new Car(name, count);
    }

    public void moveForward() {
        moveCount.addCount();
    }

    public boolean hasSameMoveCount(final Count count) {
        return moveCount.equals(count);
    }

    public String getNameValue() {
        return name.getName();
    }

    public int getMoveCountValue() {
        return moveCount.getCount();
    }

    public Count getMoveCount() {
        return moveCount;
    }
}
