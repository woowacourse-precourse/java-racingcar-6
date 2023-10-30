package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomRaceNumberGenerator implements RaceNumberGenerator {

    static final int MIN_VALUE = 0;
    static final int MAX_VALUE = 9;

    @Override
    public int generator() {
        return Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE);
    }
}
