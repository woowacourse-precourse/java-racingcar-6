package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomMovement {
    public static boolean moveForwardOrNot() {
        return Randoms.pickNumberInRange(0, 9) > 3;
    }
}
