package racingcar.domain.car;

public class Car {
    private final String name;
    private int moveCount;
    private RandomUtil randomUtil;

    public Car(String name, RandomUtil randomUtil) {
        this.name = name;
        this.moveCount = 0;
        this.randomUtil = randomUtil;
    }

    public void moveCar() {
        if(canMoveCar()) {
            this.moveCount += 1;
        }
    }

    public boolean canMoveCar() {
        return randomUtil.moveForward();
    }

    public boolean isSameAs(Car otherCar) {
        return this.moveCount == otherCar.getMoveCount();
    }

    public int compareTo(Car otherCar) {
        return this.moveCount - otherCar.getMoveCount();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
