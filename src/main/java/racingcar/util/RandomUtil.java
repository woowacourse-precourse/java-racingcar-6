package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public int createRandom() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
