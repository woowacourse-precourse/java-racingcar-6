package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static boolean moveForwardOrNot() {
        return getRandomInt() >= Constants.MOVEMENT_THRESHOLD;
    }

    private static int getRandomInt() {
        return Randoms.pickNumberInRange(Constants.RANDOM_RANGE_MIN, Constants.RANDOM_RANGE_MAX);
    }
}
