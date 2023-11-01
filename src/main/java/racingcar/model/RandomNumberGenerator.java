package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MINIMUM_RANGE = 0;
    private static final int MAXIMUM_RANGE = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_RANGE, MAXIMUM_RANGE);
    }
}
