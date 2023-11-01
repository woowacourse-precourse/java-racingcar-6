package racingcarv2.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int generateRandomNumber(final int startInclusive, final int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
