package racingcar.model;

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

    public String reportMovement() {
        String movement = "";

        for (int i = 0; i < distance; i++) {
            movement += "-";
        }
        return movement;
    }

    public void controlMovement() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            distance++;
        }
    }
}
