package racingcar;

import static racingcar.constant.RandomNumberConstant.MAXIMUM_PICK_RANDOM_NUMBER;
import static racingcar.constant.RandomNumberConstant.MINIMUM_PICK_RANDOM_NUMBER;
import static racingcar.constant.RandomNumberConstant.MOVE_FORWARD;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;

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
        if (Randoms.pickNumberInRange(MINIMUM_PICK_RANDOM_NUMBER, MAXIMUM_PICK_RANDOM_NUMBER) >= MOVE_FORWARD) {
            distance++;
        }
    }
}
