package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final Integer MIN_NUMBER = 0;
    private static final Integer MAX_NUMBER = 9;

    private RandomNumberGenerator() {
    }

    public static Integer pickNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
