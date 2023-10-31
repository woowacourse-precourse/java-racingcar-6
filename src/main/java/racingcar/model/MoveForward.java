package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveForward {

    private static final int MOVE_FORWARD = 4;
    private static final int MIN_MOVE_FORWARD = 0;
    private static final int MAX_MOVE_FORWARD = 10;

    public static Boolean success() {
        return MOVE_FORWARD <= Randoms.pickNumberInRange(MIN_MOVE_FORWARD, MAX_MOVE_FORWARD);
    }
}
