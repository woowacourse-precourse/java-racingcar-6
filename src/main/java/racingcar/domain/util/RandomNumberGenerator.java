package racingcar.domain.util;

import static racingcar.domain.constant.GameValueConstant.RANDOM_VALUE_LOWER_LIMIT;
import static racingcar.domain.constant.GameValueConstant.RANDOM_VALUE_UPPER_LIMIT;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(RANDOM_VALUE_LOWER_LIMIT.getValue(), RANDOM_VALUE_UPPER_LIMIT.getValue());
    }
}