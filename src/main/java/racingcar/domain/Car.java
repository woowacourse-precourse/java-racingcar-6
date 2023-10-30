package racingcar.domain;

import static racingcar.constant.RaceSetting.MIN_MOVE_NUMBER;
import static racingcar.constant.RaceSetting.MOVE_NUMBER;

public class Car {
    private final String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void run(int number) {
        if (move(number)) {
            distance += MOVE_NUMBER.getValue();
        }
    }

    private boolean move(int number) {
        return number >= MIN_MOVE_NUMBER.getValue();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
