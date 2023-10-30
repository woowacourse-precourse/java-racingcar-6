package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
