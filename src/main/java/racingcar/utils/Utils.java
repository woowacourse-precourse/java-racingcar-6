package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Utils {
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    public static boolean wordLengthCheck(String name) {
        if (name.length() > 5) {
            return false;
        }
        return true;
    }

    public static int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
