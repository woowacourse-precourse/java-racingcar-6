package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RealNumberGenerator implements NumberGenerator {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 9;

    @Override
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
