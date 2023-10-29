package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private final static int NUMBER_MIN_VALUE = 0;
    private final static int NUMBER_MAX_VALUE = 9;

    private RandomNumberGenerator() {}

    static public int generateRandomNumber() {
        return Randoms.pickNumberInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE);
    }
}
