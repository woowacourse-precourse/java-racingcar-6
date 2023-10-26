package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumUtil {
    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;

    public static int generateRandomNum() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

}
