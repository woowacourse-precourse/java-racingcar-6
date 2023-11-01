package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.util.Constants;

public class Car {
    private final String name;
    private int distance = 0;

    public Car(String name) {
        checkName(name);
        this.name = name;
    }

    private void checkName(String name) {
        if (name.length() > Constants.CAR_NAME_LENGTH_MAX) {
            throw new IllegalArgumentException();
        }
    }

    private void go() {
        distance += Constants.ONE_TIME_DISTANCE;
    }

    public void runOneTime() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= Constants.CAN_GO_NUMBER) {
            go();
        }
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return name;
    }
}
