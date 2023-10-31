package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int STANDARD_OF_JUDGMENT = 4;

    public boolean isIncreseDistance() {
        int pick = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
        return pick >= STANDARD_OF_JUDGMENT;
    }

}
