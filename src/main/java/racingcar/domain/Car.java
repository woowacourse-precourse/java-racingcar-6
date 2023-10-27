package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public String name;
    public String forward;
    public int forwardCount;

    public Car(String name) {
        this.name = name;
        this.forward = "";
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getForward() {
        return forward;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void setForward(String forward) {
        this.forward = forward;
    }
    public void addForwardCount() {
        forwardCount++;
    }

    public boolean shouldCarMove() {

        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
