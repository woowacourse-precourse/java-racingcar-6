package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGenerator {

    private static final int MIN_NUMBER_RANGE=0;
    private static final int MAX_NUMBER_RANGE=9;


    public int generate() {
        return Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE);
    }
}
