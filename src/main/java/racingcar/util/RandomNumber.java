package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;
    public static int pickRandomNumber() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
