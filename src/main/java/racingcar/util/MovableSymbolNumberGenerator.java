package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class MovableSymbolNumberGenerator implements NumberGenerator {

    private static final int DEFAULT_START_RANGE = 0;
    private static final int DEFAULT_END_RANGE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(DEFAULT_START_RANGE, DEFAULT_END_RANGE);
    }
}
