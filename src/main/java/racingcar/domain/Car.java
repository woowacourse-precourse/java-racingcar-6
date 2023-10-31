package racingcar.domain;

import racingcar.vo.CarName;

public class Car {

    private final CarName name;
    private int forwardCount;

    public Car(CarName name) {
        this.name = name;
        forwardCount = 0;
    }


    public void moveForward() {
        forwardCount++;
    }

    public int showForwardCount() {
        return forwardCount;
    }

    public String showName() {
        return new String(name.show());
    }

    public void checkMoveForward(boolean isCarMove) {
        if (isCarMove) {
            this.moveForward();
        }
    }

}
