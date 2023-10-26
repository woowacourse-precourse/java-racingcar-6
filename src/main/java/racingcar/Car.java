package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final StringBuilder distanceTraveled = new StringBuilder();
    private final String carName;

    Car(String carName) {
        this.carName = carName;
    }

    String getCarName() {
        return carName;
    }

    boolean isMovingForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    void moveForward() {
        distanceTraveled.append("-");
    }

    String getDistanceTraveled() {
        return distanceTraveled.toString();
    }
}
