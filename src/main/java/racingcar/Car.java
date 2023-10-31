package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    Car(String name) {
        this.name = name;
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

    int getDistance() {
        return distance;
    }

    String getName() {
        return name;
    }

    public String toString() {
        String distanceInDash = "";

        for (int i = 0; i < distance; i++) {
            distanceInDash += "-";
        }

        return String.format("%s : %s", name, distanceInDash);
    }

}
