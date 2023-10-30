package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public final class RandomNumberGenerator {

    private static final int MIN = 0;
    private static final int MAX = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(MIN, MAX);
    }
}
