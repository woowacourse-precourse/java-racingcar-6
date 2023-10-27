package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.GameConstant.MINIMUM_DICE_VALUE;

public class Car {
    private final String name;
    private int forwardCount;

    public Car(String name) {
        forwardCount = 0;
        this.name = name;
    }

    public int forward() {
        if (isCarCanForward()) {
            forwardCount++;
        }

        return forwardCount;
    }

    private boolean isCarCanForward() {
        int dice = Randoms.pickNumberInRange(0, 9);
        return dice >= MINIMUM_DICE_VALUE;
    }


    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

}
