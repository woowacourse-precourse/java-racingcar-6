package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    public static int generateRandomIntInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
