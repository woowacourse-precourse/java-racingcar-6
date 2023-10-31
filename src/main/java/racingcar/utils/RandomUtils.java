package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.utils.constant.Constant;

public class RandomUtils {
    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_NUMBER, Constant.MAX_RANDOM_NUMBER);
    }
}
