package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveStatus {
    private static final int PICK_NUM_MIN = 0;
    private static final int PICK_NUM_MAX = 9;
    private static final int FORWARD_NUM = 4;

    public boolean canMove() {
        return Randoms.pickNumberInRange(PICK_NUM_MIN,PICK_NUM_MAX) >= FORWARD_NUM;
    }
}
