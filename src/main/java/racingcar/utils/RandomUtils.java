package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    private RandomUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getRandomNumber(int minimum, int maximum) {
        return Randoms.pickNumberInRange(minimum, maximum);
    }
}
