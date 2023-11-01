package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveAmount;

    public String getName() {
        return name;
    }

    public int getMoveAmount() {
        return moveAmount;
    }

    public String getMoveResult() {
        return name + " : " + "-".repeat(Math.max(0, moveAmount));
    }

    public Car(String name) {
        this.name = name;
        this.moveAmount = 0;
    }

    public void move() {
        if (isMoveCondition()) {
            this.moveAmount++;
        }
    }
    public boolean isMoveCondition() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
