package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {

    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_END_NUMBER = 9;

    public static int pick() {
        int random = Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER);
        return random;
    }
}
