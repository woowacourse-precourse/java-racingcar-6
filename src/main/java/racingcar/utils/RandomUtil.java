package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    private RandomUtil() {
    }

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
