package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveNumberGenerator implements NumberGenerator {
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MAX_MOVE_NUMBER = 9;
    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(MIN_MOVE_NUMBER, MAX_MOVE_NUMBER);
    }
}
