package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final String DO_NOT_CALL_THIS_CODE_MESSAGE = "호출되어서는 안됩니다.";
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    private RandomNumberGenerator() {
        throw new AssertionError(DO_NOT_CALL_THIS_CODE_MESSAGE);
    }

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
