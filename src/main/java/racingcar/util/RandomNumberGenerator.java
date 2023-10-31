package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Integer MIN_NUMBER = 0;
    private static final Integer MAX_NUMBER = 9;

    @Override
    public Integer pickNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
