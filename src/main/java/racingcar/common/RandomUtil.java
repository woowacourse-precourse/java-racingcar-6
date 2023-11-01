package racingcar.common;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(Constants.NUMBER_RANGE_MIN, Constants.NUMBER_RANGE_MAX);
    }

}
