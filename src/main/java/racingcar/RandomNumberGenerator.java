package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private final int MINIMUM_TRY_COUNT = 0;
    private final int MAXIMUM_TRY_COUNT = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MINIMUM_TRY_COUNT, MAXIMUM_TRY_COUNT);
    }
}
