package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberGernator {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 9;
    private static final int STANDARD_OF_JUDGMENT = 4;

    public static int pickNumber(){
        return Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
    }
}
