package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    private static final int MIN_BOUND = 0;
    private static final int MAX_BOUND = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BOUND, MAX_BOUND);
    }
}
