package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private final Name name;
    private int moveCount;

    public Car(String name) {
        this.name = new Name(name);
        moveCount = 0;
    }

    public void controlMovement(int controlValue) {
        this.moveCount = SupportedMove.controlMovement(moveCount, controlValue);
    }

    public String getName() {
        return name.getName();
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public int compareTo(Car other) {
        return this.moveCount - other.moveCount;
    }

    public boolean findSameCar(Car other) {
        return this.moveCount == other.moveCount;
    }

}
