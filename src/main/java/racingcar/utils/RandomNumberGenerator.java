package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator{
    private static final Integer MIN_NUMBER_RANGE = 0;
    private static final Integer MAX_NUMBER_RANGE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
