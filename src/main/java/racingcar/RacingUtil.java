package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingUtil {
    private static final int MIN_POWER = 0;
    private static final int MAX_POWER = 9;

    public static int generateRandomPower() {
        return Randoms.pickNumberInRange(MIN_POWER, MAX_POWER);
    }
}
