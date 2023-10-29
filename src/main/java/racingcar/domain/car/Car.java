package racingcar.domain.car;

public class Car implements Comparable<Car> {
    private final Name name;
    private MoveCount moveCount;

    public Car(String name) {
        this.name = new Name(name);
        this.moveCount = new MoveCount();
    }

    public void controlMovement(int controlValue) {
        moveCount.controlMovement(controlValue);
    }

    public String getName() {
        return name.getName();
    }

    public int getMoveCount() {
        return moveCount.getMoveCount();
    }

    @Override
    public int compareTo(Car other) {
        return moveCount.compareTo(other.moveCount);
    }

    public boolean findSameCar(Car other) {
        return moveCount.findSameMoveCount(other.moveCount);
    }

}
