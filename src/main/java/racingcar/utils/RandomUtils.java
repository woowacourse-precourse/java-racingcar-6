package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {
    private static int MIN_RANDOM_LIMIT = 0;
    private static int MAX_RANDOM_LIMIT = 9;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_LIMIT, MAX_RANDOM_LIMIT);
    }
}
