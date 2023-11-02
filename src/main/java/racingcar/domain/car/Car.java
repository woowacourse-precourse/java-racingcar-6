package racingcar.domain.car;

import java.nio.charset.StandardCharsets;

import static racingcar.global.exception.ExceptionMessage.CAR_NAME_LESS_THAN_FIVE_LETTER;

public class Car {
    private static final int NAME_LENGTH_LIMIT = 5;

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
        if(carName.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LESS_THAN_FIVE_LETTER.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
