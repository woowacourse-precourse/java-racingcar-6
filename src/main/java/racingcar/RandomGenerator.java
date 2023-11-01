package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private static final int RANGE_START = 0;
    private static final int RANGE_END = 9;

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }
}
