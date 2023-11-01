package racingcar.data;

import racingcar.io.CarOutput;
import racingcar.utils.CarUtil;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int moveCount) {
        this.name = name;
        this.distance = moveCount;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(boolean isPossibleMove) {
        if (isPossibleMove) {
            distance++;
        }

        CarOutput.printMoveCar(name, CarUtil.SHOW_MOVE_DISTANCE.repeat(distance));
    }
}
