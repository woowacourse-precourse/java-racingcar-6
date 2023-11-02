package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGeneratorUtil {

    public static int generate(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }

    private RandomNumberGeneratorUtil() {
    }

}
