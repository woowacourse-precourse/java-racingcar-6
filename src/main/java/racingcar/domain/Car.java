package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int distance = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int distance) {
        this.distance = distance;
        this.name = name;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getName() {
        return this.name;
    }

    void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.distance++;
        }
    }
}
