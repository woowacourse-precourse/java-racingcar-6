package racingcar.function;

import camp.nextstep.edu.missionutils.Randoms;

public class GoStopRule {

    private static final int MOVE_MIN_NUMBER = 4;

    public boolean shouldGo() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= MOVE_MIN_NUMBER;
    }
}