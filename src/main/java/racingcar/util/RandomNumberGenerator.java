package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static int generate() {
        int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER); // 1부터 9까지의 랜덤 수

        return randomNumber;
    }
}
