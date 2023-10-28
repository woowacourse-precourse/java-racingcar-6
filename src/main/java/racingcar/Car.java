package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String carName;
    Long totalMovements;

    public Car(String name) {
        this.carName = name;
        this.totalMovements = 0L;
    }

    public String getCarName() {
        return carName;
    }

    public Long getToTalMovements() {
        return totalMovements;
    }

    public boolean isGo() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    public void moveForward() {
        if (isGo()) {
            totalMovements += 1;
        }
    }
}
