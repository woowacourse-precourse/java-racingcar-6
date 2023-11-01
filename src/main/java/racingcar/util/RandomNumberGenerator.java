package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    static final int MIN_NUMBER_RANGE = 0;
    static final int MAX_NUMBER_RANGE = 9;

    @Override
    public int pickNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
