package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveCount;

    Car(String name) {
        this.name = name;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            moveCount += 1;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
