package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private String distance;

    public Car(String name) {
        this.name = name;
        this.distance = "";
    }

    public void moveForward() {
        distance += "-";
    }

    public boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }
}