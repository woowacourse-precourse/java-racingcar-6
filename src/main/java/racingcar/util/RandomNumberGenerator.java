package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements RandomUtil{

    private static final Integer START_NUMBER = 0;
    private static final Integer END_NUMBER = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }
}
