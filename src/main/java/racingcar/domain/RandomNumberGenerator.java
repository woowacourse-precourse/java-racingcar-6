package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 0;

    public static int generate() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }

}
