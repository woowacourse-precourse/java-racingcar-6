package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
    }

    public void moveFoward() {
        if (isMoveFoward()) {
            position++;
        }
    }

    public boolean isMoveFoward() {
        int moveIndicator = Randoms.pickNumberInRange(Constants.MIN_RANDOM_NUM, Constants.MAX_RANDOM_NUM);
        return moveIndicator > Constants.GO_FOWARD;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
