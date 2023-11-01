package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    private static final int MINIMUM_NUMBER = 0;
    private static final int MAXIMUM_NUMBER = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER);
    }
}
