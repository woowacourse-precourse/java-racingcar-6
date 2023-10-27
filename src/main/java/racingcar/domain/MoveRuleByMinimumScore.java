package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class MoveRuleByMinimumScore implements MoveRule {
    private static final int MAX_NUMBER_SIZE = 9;
    private static final int MIN_NUMBER_SIZE = 0;
    private static final int MIN_MOVE_NUMBER = 4;
    private static final int MOVE_SUCCESS_LENGTH = 1;
    private static final int MOVE_FAIL = 0;

    @Override
    public int tryMove(int number) {
        if (number >= MIN_MOVE_NUMBER) {
            return MOVE_SUCCESS_LENGTH;
        }
        return MOVE_FAIL;
    }

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_SIZE, MAX_NUMBER_SIZE);
    }
}
