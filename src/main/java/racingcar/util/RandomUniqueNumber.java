package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUniqueNumber {

    public static final int MIN_NUMBER = 0;
    public static final int MAX_NUMBER = 9;

    public static int pickRandomUniqueNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }
}
