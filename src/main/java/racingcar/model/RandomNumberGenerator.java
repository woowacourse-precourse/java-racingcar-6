package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int MIN_RANGE_VALUE = 0;
    private static final int MAX_RANGE_VALUE = 9;
    public static Integer getRandomNUmber() {
        return Randoms.pickNumberInRange(MIN_RANGE_VALUE, MAX_RANGE_VALUE);
    }
}
