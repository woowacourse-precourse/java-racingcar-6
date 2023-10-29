package racingcar.Util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int LOWER_LIMIT_VALUE = 0;
    private static final int UPPER_LIMIT_VALUE = 9;
    public static final int DRIVEABLE_VALUE = 4;

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(LOWER_LIMIT_VALUE, UPPER_LIMIT_VALUE);
    }
}
