package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
