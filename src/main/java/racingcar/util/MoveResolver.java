package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveResolver {
    private final int MOVING_FORWARD = 4;
    private final int RANDOM_LEFT_BOUND = 0;
    private final int RANDOM_RIGHT_BOUND = 9;

    public boolean isMoveAble() {
        return getRandomNumber() >= MOVING_FORWARD;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_LEFT_BOUND, RANDOM_RIGHT_BOUND);
    }
}
