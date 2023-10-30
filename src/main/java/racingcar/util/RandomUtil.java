package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public static int createRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
