package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomsWrapper implements RandomNumberGenerator{
    private final static Integer MIN_VALUE = 0;
    private final static Integer MAX_VALUE = 9;
    @Override
    public int pickNumberInRange() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
