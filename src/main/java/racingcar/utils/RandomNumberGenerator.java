package racingcar.utils;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {

    private static final int START_NUM = 0;
    private static final int END_NUM = 9;

    public static int generateRandomNumber() {
        return Randoms.pickNumberInRange(START_NUM, END_NUM);
    }

}
