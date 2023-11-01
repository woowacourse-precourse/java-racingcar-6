package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int START_RANGE = 0;
    private static final int END_RANGE = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(START_RANGE, END_RANGE);
    }
}
