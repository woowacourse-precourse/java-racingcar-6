package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int min = 0;
    private static final int max = 9;
    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(min, max);
    }
}
