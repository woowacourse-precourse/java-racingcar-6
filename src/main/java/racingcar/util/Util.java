package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public static boolean isNullOrEmpty(String string) {
        if (string == null) {
            return true;
        }
        if (string.isEmpty()) {
            return true;
        }
        if (string.isBlank()) {
            return true;
        }
        return false;
    }

    public static int getRandomDecimalNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
