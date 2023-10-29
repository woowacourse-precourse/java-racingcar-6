package util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private RandomGenerator() {}

    /**
     * 0 ~ 9 사이의 무작위 값을 반환
     * @return Int
     */
    public static int generateNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
