package racingcar.domain;

import racingcar.util.RandomNumber;
import racingcar.util.RandomNumber.MoveOrder;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        distance = 0;
    }

    public void playRound() {
        if (RandomNumber.getMoveOrder() == MoveOrder.MOVE_FORWARD) {
            distance += 1;
        }
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

}
