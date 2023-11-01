package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;

    public int createNumber() {
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
