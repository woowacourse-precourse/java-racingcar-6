package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static int getRandomNumberRange(int startNumber, int endNumber) {
        return Randoms.pickNumberInRange(startNumber, endNumber);
    }
}
