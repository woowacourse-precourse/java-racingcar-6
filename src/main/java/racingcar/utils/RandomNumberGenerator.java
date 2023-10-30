package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int generateInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
