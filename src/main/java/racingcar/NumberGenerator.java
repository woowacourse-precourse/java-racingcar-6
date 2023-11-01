package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {
    public static final int RANDOM_NUMBER_MIN_VALUE = 0;
    public static final int RANDOM_NUMBER_MAX_VALUE = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_VALUE, RANDOM_NUMBER_MAX_VALUE);
    }
}
