package racingcar.util;

import static racingcar.consts.GameConstant.MAX_NUMBER_RANDOM_RANGE;
import static racingcar.consts.GameConstant.MIN_NUMBER_RANDOM_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANDOM_RANGE.get(),
                MAX_NUMBER_RANDOM_RANGE.get());
    }
}
