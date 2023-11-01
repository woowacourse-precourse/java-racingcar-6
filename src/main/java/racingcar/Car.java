package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MIN_RANGE_NUMBER = 0;
    private static final int MAX_RANGE_NUMBER = 9;
    private static final int MOVABLE_NUMBER = 4;
    private int position = 0;


    public void moveForward() {
        if (randomMoveNumber()) {
            this.position++;
        }
    }

    private boolean randomMoveNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE_NUMBER, MAX_RANGE_NUMBER) >= MOVABLE_NUMBER;
    }

}
