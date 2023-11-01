package racingcar.model;

public class Car {
    private final CarName carName;
    private final CarPosition carPosition;
    private final MoveRule moveRule = new MoveRule();

    public Car(String name) {
        this.carName = new CarName(name);
        this.carPosition = new CarPosition();
    }

    public void moveByCondition() {
        if (moveRule.shouldMove()) {
            carPosition.advancePosition();
        }
    }

    public String getName() {
        return this.carName.toString();
    }

    public int getPosition() {
        return this.carPosition.toInt();
    }

}
