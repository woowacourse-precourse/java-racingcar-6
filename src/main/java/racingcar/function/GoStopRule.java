package racingcar.function;

import camp.nextstep.edu.missionutils.Randoms;

public class GoStopRule {

    private static final int MOVE_MIN_NUMBER = 4;
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    public boolean shouldGo() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        return randomNumber >= MOVE_MIN_NUMBER;
    }
}