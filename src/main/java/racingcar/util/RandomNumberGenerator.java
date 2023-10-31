package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final Integer RANDOM_NUMBER_START_INCLUSIVE = 0;
    private static final Integer RANDOM_NUMBER_END_INCLUSIVE = 9;

    public static Integer pick() {
        return Randoms.pickNumberInRange(
                RANDOM_NUMBER_START_INCLUSIVE,
                RANDOM_NUMBER_END_INCLUSIVE
        );
    }

    public static Integer pinkInRange(Integer range1, Integer range2) {
        return Randoms.pickNumberInRange(range1, range2);
    }
}
