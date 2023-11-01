package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberUtil {
    private static RandomNumberUtil instance;

    private RandomNumberUtil() {
    }

    public static RandomNumberUtil getInstance() {
        if (instance == null) {
            instance = new RandomNumberUtil();
        }
        return instance;
    }

    public int pickRandomNumber(int minNum, int maxNum) {
        return Randoms.pickNumberInRange(minNum, maxNum);
    }
}
