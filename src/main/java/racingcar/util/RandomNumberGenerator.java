package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final Integer START_NUMBER = 0;
    private static final Integer END_NUMBER = 9;

    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
