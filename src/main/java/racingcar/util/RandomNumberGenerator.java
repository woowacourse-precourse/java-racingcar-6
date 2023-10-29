package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int NUMBER_MIN_VALUE = 0;
    private static final int NUMBER_MAX_VALUE = 9;

    public int generate() {
        return Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);
    }
}
