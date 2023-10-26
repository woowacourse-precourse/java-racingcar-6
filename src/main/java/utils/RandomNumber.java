package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {
    public static int create() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
