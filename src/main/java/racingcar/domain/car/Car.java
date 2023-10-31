package racingcar.domain.car;

import java.nio.charset.StandardCharsets;

public class Car {
    private final String name;
    private int moveCount;
    private RandomUtil randomUtil;

    public Car(String name, RandomUtil randomUtil) {
        validateCarNameLengthLessThanFive(name);
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

    private void validateCarNameLengthLessThanFive(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름 길이는 5글자 이내");
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
