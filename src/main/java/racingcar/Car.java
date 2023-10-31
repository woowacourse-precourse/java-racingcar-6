package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveAmount;

    public void move() {
        if (isMoveCondition()) {
            this.moveAmount++;
        }
    }
    public boolean isMoveCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
