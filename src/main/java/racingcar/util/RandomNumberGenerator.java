package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private RandomNumberGenerator() {
    }

    public static Integer generate() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
