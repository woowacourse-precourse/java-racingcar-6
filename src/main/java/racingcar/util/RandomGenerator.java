package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;

    public static int pickNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }
}
