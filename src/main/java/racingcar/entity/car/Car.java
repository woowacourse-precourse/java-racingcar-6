package racingcar.entity.car;

public class Car {
    private Name name;
    private MoveCount moveCount;

    public Car(String name) {
        this.name = new Name(name);
        this.moveCount = new MoveCount();
    }

    public void controlMovement(int controlValue){
        moveCount.controlMovement(controlValue);
    }

    public String getName() {
        return name.getName();
    }

    public int getMoveCount() {
        return moveCount.getMoveCount();
    }
}
