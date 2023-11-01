package racingcar.domain;

import racingcar.utils.Output;
import racingcar.utils.RandomUtil;

public class Car {

    private static final int MOVE_DELIMITER = 4;
    private final String name;
    private Long forwardCount;

    public Car(final String name) {
        this.name = name;
        this.forwardCount = 0L;
    }

    public void tryMove() {
        int randomNumber = RandomUtil.getRandomNumber();
        handleMove(randomNumber);
    }

    public void printCurrentLocation() {
        Output.printCurrentLocation(name, forwardCount);
    }

    public String getName() {
        return name;
    }

    public Long getForwardCount() {
        return forwardCount;
    }

    private void handleMove(int randomNumber) {
        if (randomNumber >= MOVE_DELIMITER) {
            moveForward();
        }
    }

    private void moveForward() {
        this.forwardCount++;
    }
}
