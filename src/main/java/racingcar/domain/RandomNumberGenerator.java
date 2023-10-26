package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static final int MIN_NUMBER_RANGE = 0;
    public static final int MAX_NUMBER_RANGE = 9;

    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
