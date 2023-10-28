package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int distance;

    Car() {

    }

    void moveForward() {
        distance++;
    }

    void stop() {

    }

    void decideMoveForwardOrStop() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveForward();
        } else {
            stop();
        }
    }

}
