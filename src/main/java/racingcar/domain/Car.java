package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.util.io.OutputUtils;

public class Car {

    private String name;
    private int moveDistance;

    public Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void move() {
        if (canMove(RandomNumber.createRandomNumber())) {
            moveDistance += 1;
        }
        OutputUtils.printCarMove(name, moveDistance);
    }

    private static boolean canMove(int number) {
        return number >= 4;
    }

}
