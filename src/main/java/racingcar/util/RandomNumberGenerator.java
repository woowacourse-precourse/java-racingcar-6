package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.Rule;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static Integer generate() {
        return Randoms.pickNumberInRange(Rule.MIN_POSSIBILITY, Rule.MAX_POSSIBILITY);
    }
}
