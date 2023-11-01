package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Judge {
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 9;
    private static final int MOVE_AVAILABLE_NUM = 4;

    public boolean isMoveAvailable() {
        int pickedNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        return pickedNumber >= MOVE_AVAILABLE_NUM;
    }
}
