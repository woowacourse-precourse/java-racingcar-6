package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private static final int START_NUMBER = 0;
    private static final int LIMIT_NUMBER = 9;

    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER, LIMIT_NUMBER);
    }
}
