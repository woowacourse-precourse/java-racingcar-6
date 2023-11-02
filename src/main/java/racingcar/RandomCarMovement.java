package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCarMovement {

    private static final int MOVING_FORWARD = 1;
    private static final int STOP = 0;

    /**
     * 전진 조건
     * 1. 0~9 사이의 무작위 값
     * 2. 값이 4 이상인 경우
     */
    public Integer randomTransfer() {

        int randomNum = Randoms.pickNumberInRange(0,9);

        if (randomNum >= 4) {
            return MOVING_FORWARD;
        } else {
            return STOP;
        }

    }
}
