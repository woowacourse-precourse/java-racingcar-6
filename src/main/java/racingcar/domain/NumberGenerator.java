package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    private static final int MIN_RANGE_VALUE = 0;
    private static final int MAX_RANGE_VALUE = 9;

    private NumberGenerator() {
    }

    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE_VALUE, MAX_RANGE_VALUE);
    }
}
