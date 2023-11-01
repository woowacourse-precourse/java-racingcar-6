package utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public Integer getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
