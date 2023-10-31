package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    private static final int NUMBER_START = 0;
    private static final int NUMBER_END = 9;


    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(NUMBER_START,
                NUMBER_END);
    }

}
