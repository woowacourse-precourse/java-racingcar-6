package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.NumberConstant.MAX_RANDOM_NUMBER;
import static racingcar.constant.NumberConstant.MIN_RANDOM_NUMBER;

public class RandomNumberGenerator {
    public static int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
