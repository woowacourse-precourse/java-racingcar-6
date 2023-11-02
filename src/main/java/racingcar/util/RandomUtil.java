package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.SystemConstant.RANGE_OF_END;
import static racingcar.constant.SystemConstant.RANGE_OF_START;

public class RandomUtil {

    public static int getRandomNumbers() {

        return Randoms.pickNumberInRange(RANGE_OF_START, RANGE_OF_END);
    }

}
