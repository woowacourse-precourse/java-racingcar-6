package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class GenerateRandomNumber {
    private static final int RANDOM_MIN_VALUE = 0;
    private static final int RANDOM_MAX_VALUE = 9;

    public static int generate() {
        return Randoms.pickNumberInRange(RANDOM_MIN_VALUE, RANDOM_MAX_VALUE);
    }
}
