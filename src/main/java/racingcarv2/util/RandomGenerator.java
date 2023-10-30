package racingcarv2.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int generateRandomNumber(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
