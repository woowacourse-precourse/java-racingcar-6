package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {
    private static final int START_NUMBER_RANGE = 0;
    private static final int END_NUMBER_RANGE = 9;

    public int generate() {
        return Randoms.pickNumberInRange(START_NUMBER_RANGE, END_NUMBER_RANGE);
    }
}
