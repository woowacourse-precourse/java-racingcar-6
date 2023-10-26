package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void moveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance += 1;
        }
    }
}
