package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int move = 0;

    public Car(String name) {
        this.name = name;
    }

    public int getMove() {
        return move;
    }

    public void moveOne() {
        int moving = Randoms.pickNumberInRange(0, 9);
        if (moving >= 4) {
            move++;
        }
        return;
    }

    public String getName() {
        return this.name;
    }
}
