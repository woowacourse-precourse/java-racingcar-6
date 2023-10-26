package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        forwardCount = 0;
        this.name = name;
    }

    public void forward() {
        if (isCarCanForward()) {
            forwardCount++;
        }
    }

    private boolean isCarCanForward() {
        int dice = Randoms.pickNumberInRange(1, 9);
        return dice > 4;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public String getName() {
        return name;
    }

}
