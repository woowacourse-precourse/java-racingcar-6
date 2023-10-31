package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    final static int MIN = 0;
    final static int MAX = 9;

    RandomNumberGenerator() {}

    public static int pickNumberInRange() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
