package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int distance = 0;

    public int getDistance() {
        return distance;
    }

    void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            distance++;
        }
    }
}
