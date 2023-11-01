package racingcar;

import static racingcar.constant.RandomNumberConstant.MOVE_FORWARD;
import static racingcar.constant.RandomNumberConstant.NINE;
import static racingcar.constant.RandomNumberConstant.ZERO;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;

    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(ZERO.number(), NINE.number()) >= MOVE_FORWARD.number()) {
            distance++;
        }
    }
}
