package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean isMove(final int movingNumber) {
        if (movingNumber >= 4) {
            return true;
        } else {
            return false;
        }
    }
}