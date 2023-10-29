package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Constant;

public class RandomNumberGenerator {
    public static Integer pick() {
        return Randoms.pickNumberInRange(Constant.RANDOM_NUMBER_START_INCLUSIVE, Constant.RANDOM_NUMBER_END_INCLUSIVE);
    }
}
