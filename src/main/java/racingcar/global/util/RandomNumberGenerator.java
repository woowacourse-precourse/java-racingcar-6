package racingcar.global.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generate(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
