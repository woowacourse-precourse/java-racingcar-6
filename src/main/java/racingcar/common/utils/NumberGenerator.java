package racingcar.common.utils;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.common.consts.SystemConst;

public class NumberGenerator {
    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(SystemConst.MIN_DIGIT_SIZE, SystemConst.MAX_DIGIT_SIZE);
    }
}
