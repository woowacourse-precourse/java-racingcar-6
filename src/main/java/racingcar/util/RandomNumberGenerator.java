package racingcar.util;

import static racingcar.constant.Constant.RANDOM_MAX_RANGE;
import static racingcar.constant.Constant.RANDOM_MIN_RANGE;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    private RandomNumberGenerator() {
    }

    public static Integer generate() {
        return Randoms.pickNumberInRange(RANDOM_MIN_RANGE, RANDOM_MAX_RANGE);
    }
}
