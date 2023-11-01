package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
