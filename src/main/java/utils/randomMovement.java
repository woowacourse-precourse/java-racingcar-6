package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class randomMovement {
    public static boolean moveForwardOrNot() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
