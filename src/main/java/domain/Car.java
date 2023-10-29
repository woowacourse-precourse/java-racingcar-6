package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    private static final int MOVE_NUM = 4;

    private CarName name;
    private int score = 0;

    public Car(CarName name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }

    public int getScore() {
        return score;
    }

    public void move() {
        if (isMove()) {
            score++;
        }
    }

    public boolean isMove() {
        if (Randoms.pickNumberInRange(MIN_NUM, MAX_NUM) >= MOVE_NUM) {
            return true;
        }
        return false;
    }
}
