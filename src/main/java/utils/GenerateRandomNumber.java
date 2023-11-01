package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {
    static final int MIN = 0;
    static final int MAX = 9;

    public static int pick() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
