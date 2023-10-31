package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public int moveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (randomNumber >= 4) {
            distance++;
        }
        return distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
