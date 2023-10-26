package racingcar.model;

public class Car {

    private CarName name;
    private MoveCount count;
    private StringBuilder step;

    public Car(CarName name) {
        this.name = name;
        this.count = new MoveCount();
        this.step = new StringBuilder(name.toString()).append(" : ");
    }

    public void moveForward(int number) {
        if (number >= 4) {
            step.append("-");
            this.count.increaseMoveCount();
        }
    }

    public String printCurrentStatus() {
        return step.toString();
    }

    public int getMoveCount() {
        return this.count.getCount();
    }

    public String getName() {
        return name.toString();
    }
}
