package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class Util {
    private final static int START_INCLUSIVE = 0;
    private final static int END_INCLUSIVE = 9;
    private final static int FORWARD_POINT = 4;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static boolean isMove(final int movingNumber) {
        if (movingNumber >= FORWARD_POINT) {
            return true;
        } else {
            return false;
        }
    }
}