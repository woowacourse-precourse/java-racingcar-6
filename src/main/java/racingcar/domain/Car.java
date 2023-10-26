package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int distance = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            distance++;
        }
    }
}
