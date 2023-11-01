package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final Integer RANDOM_NUMBER_START = 0;
    private static final Integer RANDOM_NUMBER_END = 9;

    public static Integer pick() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_END);
    }

    public static Integer pinkInRange(Integer range1, Integer range2) {
        return Randoms.pickNumberInRange(range1, range2);
    }
}
