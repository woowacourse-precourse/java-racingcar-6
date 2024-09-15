package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomValue {
    public static int getRandomValue() {
        return Randoms.pickNumberInRange(Constant.MIN_RANDOM_VALUE, Constant.MAX_RANDOM_VALUE);
    }
}
