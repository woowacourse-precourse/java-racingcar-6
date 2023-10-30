package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    private static final int MIN_RANDOM_LIMIT = 0;
    private static final int MAX_RANDOM_LIMIT = 9;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_LIMIT, MAX_RANDOM_LIMIT);
    }
}
