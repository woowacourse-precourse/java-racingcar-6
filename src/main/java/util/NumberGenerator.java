package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
