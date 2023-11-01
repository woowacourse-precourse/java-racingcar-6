package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVE_FORWARD_CRITERION = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveForwardRandomly() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_FORWARD_CRITERION) {
            this.position++;
        }
    }

    public boolean isPositionGreaterThan(int num) {
        return false;
    }
}
